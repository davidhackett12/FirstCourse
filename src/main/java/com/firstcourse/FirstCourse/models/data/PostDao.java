package com.firstcourse.FirstCourse.models.data;

import com.firstcourse.FirstCourse.models.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface PostDao extends CrudRepository<Post, Integer> {
}
