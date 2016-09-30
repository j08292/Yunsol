package kr.spring.qna.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import kr.spring.qna.domain.QnaCommand;
import kr.spring.qna.domain.QnaReplyCommand;

@Repository
public interface QnaMapper {

	
	/*
	private int qna_num;//글번호
	private String qna_title;//글제목
	private String qna_passwd;//글작성 비밀번호
	private String qna_content;//qna작성내용
	private String qna_regdate;//작성일
	private int qna_hit;//조회수
	private String mem_id;
	*/
	

	//게시글
	public List<QnaCommand> list(Map<String,Object>map);
	public int getRowCount(Map<String,Object>map);
	@Insert("INSERT INTO qna(qna_num,mem_id,qna_title,qna_content,qna_passwd,qna_hit,qna_regdate)"
			+ " VALUES (qna_num.nextval, #{mem_id}, #{qna_title},#{qna_content},#{qna_passwd},0,sysdate)")
	public void insert(QnaCommand qnaCommand);
	@Select("SELECT * FROM qna WHERE qna_num = #{qna_num}")
	public QnaCommand selectQna(Integer qna_num);
	@Update("UPDATE qna SET qna_hit = qna_hit+1 WHERE qna_num = #{qna_num}")
	public void updateHit(Integer qna_num);
	@Update("UPDATE qna SET qna_title=#{qna_title}, qna_content= #{qna_content}, qna_passwd=#{qna_passwd} WHERE qna_num = #{qna_num}")
	public void update(QnaCommand qnaCommand);
	@Delete("DELETE FROM qna WHERE qna_num = #{qna_num}")
	public void delete(Integer qna_num);
	
	
	
	
	/*
	 * private int qna_re_num;//댓글번호
	private int qna_num;//게시글번호
	private String mem_id;//작성자아이디
	private int qna_re_content;//댓글내용
	private String qna_re_regdate;//작성시간
	private int mem_level;//관리자
	*/
	
	//댓글
	public List<QnaReplyCommand> listReply(Map<String, Object> map);
	@Select("SELECT count(*) FROM qna_reply WHERE qna_num= #{qna_num}")
	public int getRowCountReply(Map <String, Object> map);
	@Insert("INSERT INTO qna_reply (qna_re_num, qna_re_content, qna_re_regdate,qna_num,mem_id,mem_level) "
			+ "VALUES (qna_re_num.nextval,#{qna_re_content},sysdate,#{qna_num}, #{mem_id}, #{mem_level})")
	public void insertReply(QnaReplyCommand qnaReplyCommand);
	@Update("UPDATE qna_reply SET qna_re_content = #{qna_re_content} WHERE qna_re_num = #{qna_re_num}")
	public void updateReply(QnaReplyCommand qnaRepluCommand);
	@Delete("DELETE FROM qna_reply WHERE qna_re_num = #{qna_re_num}")
	public void deleteReply(Integer qna_re_num);
	
	//부모글에 댓글이 있으면 부모글삭제시 댓글을 먼저 삭제해야 함
	//부모글의 글번호로 댓글 삭제
	@Delete("DELETE FROM qna_reply WHERE qna_num = #{qna_num}")
	public void deleteReplyByReview_num(Integer qna_num);
	
	/*@Select("SELECT count(*) FROM qna_reply WHERE qna_re_num=#{qna_re_num}")
	public int getReplyCount(Map <String, Object> map);
	 */
	
	//관리자=========================================================
	public List<QnaCommand> adminList(Map<String, Object> map);
	public void deleteByQnaNum(List<Integer> list);
	//해당 글번호에 작성된 모든 댓글 삭제
	public void deleteReplyByQnaNum(List<Integer> list);

}
