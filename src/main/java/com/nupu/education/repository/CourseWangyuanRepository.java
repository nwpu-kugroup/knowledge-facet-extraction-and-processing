package com.nupu.education.repository;

import com.nupu.education.domain.CourseWangyuan;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author liwei
 */
public interface CourseWangyuanRepository extends JpaRepository<CourseWangyuan, Long> {

    /**
     * 根据课程名查询网院课程
     *
     * @param courseWiki
     * @return
     */
    public CourseWangyuan findByCourseWiki(String courseWiki);
}
