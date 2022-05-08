package capstone.jejuTourrecommend.domain.Service;


import capstone.jejuTourrecommend.repository.*;
import capstone.jejuTourrecommend.web.login.exceptionClass.UserException;
import capstone.jejuTourrecommend.web.spotPage.PictureDto;
import capstone.jejuTourrecommend.web.spotPage.ReviewDto;
import capstone.jejuTourrecommend.web.spotPage.ScoreDto;
import capstone.jejuTourrecommend.web.spotPage.SpotDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class TestService {

    private final SpotRepository spotRepository;
    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;
    private final PictureRepository pictureRepository;
    private final MemberSpotRepository memberSpotRepository;
    private final ScoreRepository scoreRepository;


    public SpotDto testSpot(Long spotId){

        SpotDto spotDto = spotRepository.findOptionById(spotId).map(s -> new SpotDto(s))
                .orElseThrow(() -> new UserException("등록되지 않은 관광지 입니다"));

        return spotDto;

    }

    public ReviewDto testReview(Long reviewId){

        ReviewDto reviewDto = reviewRepository.findById(reviewId).map(r -> new ReviewDto(r))
                .orElseThrow(() -> new UserException("등록되지 않은 리뷰 입니다"));

        return reviewDto;

    }

    public PictureDto testPicture(Long pictureId){

        PictureDto pictureDto = pictureRepository.findById(pictureId).map(p -> new PictureDto(p))
                .orElseThrow(() -> new UserException("등록되지 않은 사진 url 입니다"));


        return pictureDto;

    }


    public ScoreDto testScore(Long scoreId){

        ScoreDto scoreDto = scoreRepository.findOptionalById(scoreId).map(s -> new ScoreDto(s))
                .orElseThrow(() -> new UserException("등록되지 않은 점수 입니다"));


        return scoreDto;

    }

}














