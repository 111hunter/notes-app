package com.jpa.springjpademo.dao;

import com.jpa.springjpademo.entity.Notes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotesDao extends JpaRepository<Notes, String> {
}
