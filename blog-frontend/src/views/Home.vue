<template>
  <div>
    <div class="text-center">
      <h1>Notes</h1>
      <p>The blog built with Spring Boot and Vue.js</p>
      <div v-if="posts.length === 0">
        <h2 class="text-warning">No post found at the moment</h2>
      </div>
    </div>

    <div class="row">
      <div class="col-md-4" v-for="post in posts" :key="post.notes_id">
        <div class="card mb-4 shadow">
          <div class="card-body">
            <h2 class="card-img-top text-info">{{ post.title }}</h2>
            <p class="card-text text-truncate">{{ post.content }}</p>
            <div class="d-flex justify-content-center align-items-center">
              <div class="btn-group" style="margin-bottom: 1rem;">
                <router-link
                  :to="{name: 'Post', params: {id: post.id}}"
                  class="btn btn-sm btn-outline-info"
                >View Post</router-link>
                <router-link
                  :to="{name: 'Edit', params: {id: post.id}}"
                  class="btn btn-sm btn-outline-warning"
                >Edit Post</router-link>
                <button
                  class="btn btn-sm btn-outline-danger"
                  v-on:click="deletePost(post.id)"
                >Delete Post</button>
              </div>
            </div>

            <div class="card-footer">
              <small
                class="text-muted"
              >Posted on: {{ new Date(post.updateTime).toLocaleDateString()}}</small>
              <br />
              <small class="text-muted">by: {{ post.author}}</small>
            </div>
          </div>
        </div>
      </div>
    </div>

    <div class="container">
      <!-- 按钮：用于打开模态框 -->
      <button
        v-if="this.posts.length"
        class="btn btn-warning"
        data-toggle="modal"
        data-target="#myModal"
      >Delete All Post</button>

      <!-- 模态框 -->
      <div class="modal" id="myModal">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header" style="border-bottom: 0">
              <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <div class="modal-body">Are you sure to delete all posts?</div>
            <div class="modal-footer" style="border-top: 0">
              <button class="btn btn-info" data-dismiss="modal">Quit</button>
              <button v-on:click="deleteAllPost()" class="btn btn-danger" data-dismiss="modal">Sure</button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
// @ is an alias to /src
import { server } from "@/utils/helper";
import axios from "axios";

export default {
  data() {
    return {
      posts: []
    };
  },
  created() {
    this.fetchPosts();
  },
  methods: {
    fetchPosts() {
      axios.get(`${server.baseURL}/all`).then(data => {
        this.posts = data.data;
      });
    },
    deletePost(id) {
      axios.delete(`${server.baseURL}/delete/?notes_id=${id}`).then(data => {
        window.location.reload();
      });
    },
    deleteAllPost() {
      axios.delete(`${server.baseURL}/delete/all`).then(data => {
        window.location.reload();
      });
    }
  }
};
</script>

