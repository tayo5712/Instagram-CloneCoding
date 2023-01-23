package com.cos.photogramstart.service;

import com.cos.photogramstart.domain.likes.LikesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class LikesService {
    private final LikesRepository likesRepository;

    @Transactional
    public void 좋아요(Long imageId, Long principalId) {
        likesRepository.mLikes(imageId, principalId);
    }

    @Transactional
    public void 좋아요취소(Long imageId, Long principalId) {
        likesRepository.mUnLikes(imageId, principalId);
    }
}
