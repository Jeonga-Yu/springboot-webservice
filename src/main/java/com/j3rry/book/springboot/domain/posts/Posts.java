package com.j3rry.book.springboot.domain.posts;

import com.j3rry.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}

/*
* Posts 클래스는 실제 DB의 테이블과 매칭될 클래스이며 보통 Entity 클래스 라고도 한다.
* JPA를 사용하면 DB 데이터에 작업할 경우 실제 쿼리를 날리기 보다 이 Entity 클래스의 수정을 통해 작업한다.
* Entity 클래스에서는 절대 Setter 메소드를 만들지 않는다.
* 대신 빌터 패턴을 이용해 값을 채워 DB에 삽입한다.
* */