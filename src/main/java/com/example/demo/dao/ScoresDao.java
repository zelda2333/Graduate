package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.ScoresAndInfo;
import com.example.demo.entity.StudentScores;

public interface ScoresDao {
	//查看所有学生的成绩
	List<ScoresAndInfo> ListScoresAndInfo();
	
	//根据成绩ID学生的成绩
	ScoresAndInfo FindScoresAndInfoByScoreId(int scoreId);
	//添加成绩
	int addScores(StudentScores stuScores);
	//修改成绩
	int updateScores(StudentScores stuScores);
}
