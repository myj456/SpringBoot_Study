package com.study.board.service;

import com.study.board.entity.Board;
import com.study.board.repsotiroy.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    // 글 작성 처리
    public void write(Board board, MultipartFile file) throws IOException {
        // 현재 경로를 root로 변환(.getProperty)한 후 + '경로'로 이동함.
        String projectPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\files";

        UUID uuid = UUID.randomUUID();
        String fileName = uuid + "_" + file.getOriginalFilename();

        // 파일 새로 만듬(경로, 파일 이름)
        File saveFile = new File(projectPath, fileName);

        // 파일 저장
        file.transferTo(saveFile);

        // 파일값 DB 저장
        board.setFilename(fileName); // 파일 이름
        board.setFilePath("/files/" + fileName);  // 파일 경로

        boardRepository.save(board);
    }

    // 게시글 리스트 처리
    public Page<Board> boardList(Pageable pageable) {
        return boardRepository.findAll(pageable);
    }

    public Page<Board> boardSearchList(String searchkeyword, Pageable pageable){
        return boardRepository.findByTitleContaining(searchkeyword, pageable);
    }

    // 특정 게시글 불러오기
    public Board boardView(Integer id){
        return boardRepository.findById(id).get();
    }

    // 특정 게시글 삭제
    public void boardDelete(Integer id){
        boardRepository.deleteById(id);
    }
}
