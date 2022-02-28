## 미니 프로젝트
목차
- [미니 프로젝트](#미니-프로젝트)
    - [트리구조](#트리구조)
    - [패키지구조](#패키지구조)
    - [테이블구조](#테이블구조)
    - [sql문](#sql문)

#### 트리구조
reply_board
├── docu
│   ├── 3차 프로젝트 아이디어.md
│   ├── board.mdj
│   ├── miniproject.mwb
│   ├── miniproject.mwb.bak
│   ├── miniproject.sql
│   ├── 발표제출문서.md
│   ├── 최종회차 프로젝트 소개서.md
│   └── 프로젝트 소개서.md
├── pom.xml
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── com
│   │   │   │   └── choi
│   │   │   │       └── board
│   │   │   │           ├── common
│   │   │   │           │   ├── AuthUser.java
│   │   │   │           │   ├── Board.java
│   │   │   │           │   ├── Member.java
│   │   │   │           │   ├── Message.java
│   │   │   │           │   ├── MessageDuo.java
│   │   │   │           │   ├── Notice.java
│   │   │   │           │   ├── NoticeReply.java
│   │   │   │           │   ├── Page.java
│   │   │   │           │   ├── PageNavigator.java
│   │   │   │           │   ├── RegisterCode.java
│   │   │   │           │   └── Reply.java
│   │   │   │           ├── controller
│   │   │   │           │   ├── BoardController.java
│   │   │   │           │   ├── HomeController.java
│   │   │   │           │   ├── MemberController.java
│   │   │   │           │   ├── MessageController.java
│   │   │   │           │   └── NoticeController.java
│   │   │   │           ├── dataservice
│   │   │   │           │   ├── BoardDAO.java
│   │   │   │           │   ├── IMessageDAO.java
│   │   │   │           │   ├── MemberDAO.java
│   │   │   │           │   ├── MessageDAO.java
│   │   │   │           │   └── NoticeDAO.java
│   │   │   │           ├── service
│   │   │   │           │   ├── BoardService.java
│   │   │   │           │   ├── IBoardService.java
│   │   │   │           │   ├── IMemberService.java
│   │   │   │           │   ├── IMessageService.java
│   │   │   │           │   ├── INoticeService.java
│   │   │   │           │   ├── MailSendService.java
│   │   │   │           │   ├── MemberService.java
│   │   │   │           │   ├── MessageService.java
│   │   │   │           │   └── NoticeService.java
│   │   │   │           └── util
│   │   │   │               └── JdbcUtil.java
│   │   │   └── config
│   │   │       ├── BeanConfig.java
│   │   │       ├── MailAuthConfiguration.java
│   │   │       └── MvcConfig.java
│   │   ├── resources
│   │   │   └── static
│   │   │       ├── css
│   │   │       │   ├── boardlist.css
│   │   │       │   ├── bootstrap.css
│   │   │       │   ├── context.css
│   │   │       │   ├── home.css
│   │   │       │   ├── m
│   │   │       │   │   ├── boardlist.css
│   │   │       │   │   ├── bootstrap.css
│   │   │       │   │   └── home.css
│   │   │       │   └── naver.css
│   │   │       ├── fonts
│   │   │       │   └── glyphicons-halflings-regular.woff2
│   │   │       ├── img
│   │   │       │   ├── 1.png
│   │   │       │   ├── 2.png
│   │   │       │   ├── 3.png
│   │   │       │   ├── 404.png
│   │   │       │   ├── design.png
│   │   │       │   └── no_image.jpeg
│   │   │       └── js
│   │   │           ├── bootstrap.js
│   │   │           ├── bootstrap.min.js
│   │   │           ├── ckeditor.js
│   │   │           ├── context.js
│   │   │           ├── custom.js
│   │   │           ├── jQuery-3.6.0.js
│   │   │           ├── login-register.js
│   │   │           └── npm.js
│   │   └── webapp
│   │       ├── NewFile.jsp
│   │       └── WEB-INF
│   │           ├── index.html
│   │           ├── tags
│   │           │   ├── hasProfile.tag
│   │           │   ├── isAdmin.tag
│   │           │   ├── isLogin.tag
│   │           │   ├── notAdmin.tag
│   │           │   ├── notLogin.tag
│   │           │   ├── nullProfile.tag
│   │           │   └── pre.tag
│   │           ├── views
│   │           │   ├── board
│   │           │   │   ├── editor.html
│   │           │   │   ├── list.jsp
│   │           │   │   ├── modify.jsp
│   │           │   │   ├── read.jsp
│   │           │   │   └── write.jsp
│   │           │   ├── error
│   │           │   │   ├── error.jsp
│   │           │   │   ├── error404.jsp
│   │           │   │   └── error500.jsp
│   │           │   ├── home.jsp
│   │           │   ├── include
│   │           │   │   ├── aside.jsp
│   │           │   │   ├── footer.jsp
│   │           │   │   ├── head.jsp
│   │           │   │   └── header.jsp
│   │           │   ├── m
│   │           │   │   ├── board
│   │           │   │   │   ├── list.jsp
│   │           │   │   │   ├── modify.jsp
│   │           │   │   │   ├── read.jsp
│   │           │   │   │   └── write.jsp
│   │           │   │   ├── home.jsp
│   │           │   │   ├── include
│   │           │   │   │   ├── aside.jsp
│   │           │   │   │   ├── footer.jsp
│   │           │   │   │   ├── head.jsp
│   │           │   │   │   ├── header.jsp
│   │           │   │   │   └── memberheader.jsp
│   │           │   │   ├── member
│   │           │   │   │   ├── 관리자로그인.jsp
│   │           │   │   │   ├── 내정보보기.jsp
│   │           │   │   │   ├── 로그아웃.jsp
│   │           │   │   │   ├── 로그인.jsp
│   │           │   │   │   └── 회원가입창.jsp
│   │           │   │   ├── notice
│   │           │   │   │   ├── list.jsp
│   │           │   │   │   ├── modify.jsp
│   │           │   │   │   ├── read.jsp
│   │           │   │   │   └── write.jsp
│   │           │   │   ├── redirect.jsp
│   │           │   │   └── 참고한자료.jsp
│   │           │   ├── member
│   │           │   │   ├── profile.jsp
│   │           │   │   ├── 관리자로그인팝업.jsp
│   │           │   │   ├── 내정보보기.jsp
│   │           │   │   ├── 로그아웃.jsp
│   │           │   │   ├── 로그인팝업.jsp
│   │           │   │   ├── 팝업종료.jsp
│   │           │   │   ├── 회원가입결과.jsp
│   │           │   │   └── 회원가입창.jsp
│   │           │   ├── message
│   │           │   │   ├── 메시지상세보기.jsp
│   │           │   │   ├── 메시지전송팝업.jsp
│   │           │   │   └── 쪽지함팝업.jsp
│   │           │   ├── notice
│   │           │   │   ├── list.jsp
│   │           │   │   ├── modify.jsp
│   │           │   │   ├── read.jsp
│   │           │   │   └── write.jsp
│   │           │   ├── redirect.jsp
│   │           │   ├── upload
│   │           │   └── 참고한자료.jsp
│   │           └── web.xml


#### 패키지구조
<img src="../ToyProject/Reply_Board/img/패키지구조.png">

#### 테이블구조
<img src="../ToyProject/Reply_Board/img/테이블구조.png">

#### sql문
[miniproject.sql](../ToyProject/Reply_Board/docu/miniproject.sql)