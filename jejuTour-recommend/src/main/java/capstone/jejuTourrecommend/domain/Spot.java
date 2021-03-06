package capstone.jejuTourrecommend.domain;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of={"id","username","address","description","location","score"})//원래 연관관계 없는 필드만 넣어야 서로 toSting 하면 무한루프 발생함
//@Table(indexes = @Index(name = "i_spot", columnList = "spot_id"))
public class Spot {


    @Id @GeneratedValue
    @Column(name = "spot_id")
    private Long id;
    private String name;
    private String address;
    private String description;

    @Enumerated(EnumType.STRING)
    private Location location;  //제주 읍 위치

    //@Enumerated(EnumType.STRING)
    //private Category category;


    @OneToMany(mappedBy = "spot")
    private List<FavoriteSpot> favoriteSpotList = new ArrayList<>();

    @OneToMany(mappedBy = "spot")
    private List<MemberSpot> memberSpotList = new ArrayList<>();

    @OneToMany(mappedBy = "spot")
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "spot")
    private List<Picture> pictures = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "score_id")
    private Score score;



    private void changeScore(Score score){
        this.score =score;
        score.setSpot(this);
    }

    public Spot(String name) {
        this.name = name;
    }

    public Spot(String name,Score score) {
        this.name = name;
        if(score!= null){
            changeScore(score);
        }
    }

    public Spot(Location location, Score score) {
        this.location = location;
        if(score!= null){
            changeScore(score);
        }
    }


}




























