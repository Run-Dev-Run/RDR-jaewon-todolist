package com.drd.rdr_to_do_list.api.diary.controller;

import com.drd.rdr_to_do_list.api.diary.service.DiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/diary")
@RequiredArgsConstructor
@RestController
public class DiaryController extends DiaryControllerForSwagger {
    private final DiaryService diaryService;

    @GetMapping(name = "Diary 목록")
    public ResponseEntity<Void> list() {
        return null;
    }

    // ModelAttribute 대신 RequestBody 쓰기
    @PostMapping(name = "Diary 추가")
    public ResponseEntity<Void> add(@RequestParam("name") String name) {
        diaryService.add(name);
        return null;
    }
}
