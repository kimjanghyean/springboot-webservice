package springboot.domain.posts;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import springboot.domain.BaseTimeEntity;
@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {
	
	@Id //엔티티의 기본키를 @id 어노테이션으로 사용하여 설정하는데   -----ㄱ
	@GeneratedValue(strategy = GenerationType.IDENTITY) //IDENTITY사용으로 기본키 생성을 데이터베이스에 위임한다(데이터베이서에 의존적)
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
