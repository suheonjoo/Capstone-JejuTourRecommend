package capstone.jejuTourrecommend.web.mainPage;

import capstone.jejuTourrecommend.domain.Location;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

import java.util.List;

@Data
public class SpotLocationDto {//장소만 선택됐을때의 dto임


//    spot: {
//        id: number,  // 관광지 id
//                name: string,  // 관광지 이름
//                address: string,  // 관광지 주소
//                description: string,  // 관광지 설명 ****이부분은 넣을까 고민중
//                picture: string,  // 관광지 사진 url
//
//    }[]

    //이걸 보면 picture, score와 매핑해야
    //score 점수 기반으로 절렬해서 보여주고 , picture에서 사진 url을 가져와햐함
    private Long spotId;
    private String spotName;
    private String spotAddress;
    private String spotDescription;
    private List<String> url;



    @QueryProjection
    public SpotLocationDto(Long spotId, String spotName, String spotAddress, String spotDescription, List<String> url) {
        this.spotId = spotId;
        this.spotName = spotName;
        this.spotAddress = spotAddress;
        this.spotDescription = spotDescription;
        this.url = url;
    }
}





