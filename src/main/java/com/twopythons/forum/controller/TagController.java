package com.twopythons.forum.controller;

import com.twopythons.forum.controller.mapper.TagMapper;
import com.twopythons.forum.model.dto.TagDto;
import com.twopythons.forum.model.entity.Tag;
import com.twopythons.forum.model.service.impl.TagServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("tags")
public class TagController extends CommonController<TagMapper, TagServiceImpl, TagDto, Tag> {

    @Autowired
    public TagController(TagServiceImpl service, TagMapper mapper) {
        super(service, mapper);
    }

    @Override
    public void save(@Valid @RequestBody TagDto dto) {
        service.getTagByName(dto.getName());
    }
}
