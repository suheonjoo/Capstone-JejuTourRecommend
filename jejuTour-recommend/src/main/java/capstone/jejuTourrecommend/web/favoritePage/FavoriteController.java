package capstone.jejuTourrecommend.web.favoritePage;


import capstone.jejuTourrecommend.domain.Service.FavoriteService;
import capstone.jejuTourrecommend.web.GlobalDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class FavoriteController {

    private final FavoriteService favoriteService;

    //사용자의 위시리스트 목록 "폼" 보여주기
    // 사용자 정보, 관광지 정보 필요
    @GetMapping("/favorite/form")
    public FavoriteListDto getFavoriteForm(){

        //테스트용 데이터
        Long memberId = 1l;

        Page<FavoriteDto> favoriteList = favoriteService.getFavoriteList(memberId);

        return new FavoriteListDto(200l,true,"성공,",favoriteList);


    }


    // 선택한 관광지를 선태한 위시리스트에 추가
    // 선택한 관광지 정보, 사용자 정보, 위시리스트 정보 필요
    @PostMapping("/favorite/form")
    public GlobalDto postFavoriteForm(){

        //테스트용 데이터
        Long memberId = 1l;
        Long spotId = 7l;
        Long favoriteId = 8l;

        favoriteService.postFavoriteForm(memberId,spotId,favoriteId);

        return new GlobalDto(200l,true,"성공");


    }//나 여기서 get post 의미를 정보 수정의 의미로 두었음 반화값은 유무가 아니라

    //새로운 위시 리스트를 만들고 해당 관광지 넣기
    // 선택한 관광지 정보, 사용자 정보, 위시리스트 이름 필요
    @GetMapping("/favorite/new")
    public GlobalDto newFavoriteList(){

        //여기서 관광지 정보 유무로 나눠야 함
        //있으면 위시리스트 생성 및 관광지 추가, 없으면 그냥 위시리스트 생성

        //테스트용 데이터
        Long memberId = 1l;
        Long spotId = 7l;
        String favoriteName = "1일차 관광지";

        if(spotId!=null){//관광지 정보가 있으면

            favoriteService.newFavoriteListO(memberId,spotId,favoriteName);

        }
        else{//관광지 정보가 없으면

            favoriteService.newFavoriteListX(memberId,favoriteName);

        }
        return new GlobalDto(200l,true,"성공");
    }

    //위시 리스트 페이지
    //사용자 정보 필요
    @GetMapping("/favoriteList")
    public FavoriteListDto favoriteList(){

        //테스트용 데이터
        Long memberId = 1l;

        Page<FavoriteDto> favoriteList = favoriteService.getFavoriteList(memberId);

        return new FavoriteListDto(200l,true,"성공,",favoriteList);

    }

    //위시 리스트 삭제하기
    //해당 위시리스트 정보 필요
    @PostMapping("/favoriteList")
    public void deleteFavoriteList(){

        //테스트용 데이터
        Long memberId;
        Long favoriteId;




    }



}












