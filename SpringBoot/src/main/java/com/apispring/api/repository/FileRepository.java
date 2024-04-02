package com.apispring.api.repository;

import com.apispring.api.models.FileStorage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<FileStorage,Integer> {
    FileStorage findByfilename(String filename);
}
