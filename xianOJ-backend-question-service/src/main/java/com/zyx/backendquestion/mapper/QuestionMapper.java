package com.zyx.backendquestion.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zyx.backendmodel.model.entity.Question;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 24088
* @description 针对表【question(题目)】的数据库操作Mapper
* @createDate 2024-01-03 16:01:08
* @Entity com.zyx.zyxio.model.entity.Question
*/
@Mapper
public interface QuestionMapper extends BaseMapper<Question> {

}




