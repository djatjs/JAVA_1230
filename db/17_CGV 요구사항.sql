/*
영화 예매 사이트
조회(무비 차트)
	- 사용자는 등록된 현재 상영 혹은 상영 예정 영화를 조회한다.
    - 영화는 예매 내역이 많은 순으로 조회한다.
조회(상영 시간)
	- 사용자는 영화, 극장, 날짜를 선택하여 상영시간을 확인한다.
    - 사용자는 현재 상영 중이거나 상영 예정인 영화를 선택한다.
    - 사용자는 현재 운영 중인 극장을 선택한다.
    - 사용자는 상영시간으로 등록된 날짜를 선택한다.
    - 사용자는 영화, 극장, 날짜를 선택하여 상영시간 및 상영관과 전체좌석수/예매가능 좌석수를 확인한다.
조회(영화 상세 내용)
	- 사용자는 영화를 선택하여 상세 조회를 한다.
    - 상세 정보는 감독, 배우, 장르, 기본정보, 개봉일, 영화 설명, 트레일러, 스틸컷이 있다.
    - 감독은 영화를 연출한 감독으로 등록된 감독 모두를 조회한다.
    - 배우는 영화에 참여한 배우로, 영화를 등록할 때 참여한 배우를 등록한 순으로 조회한다.
    - 장르는 영화 장르로, 등록된 장르 모두를 나타낸다.
    - 기본 정보는 관람 나이, 런닝시간(분), 제작 국가가 조회된다.
	- 여러 나라에서 제작한 경우, 제작 국가가 여러 나라가 된다.
검색
	- 사용자는 검색어를 입력하여 검색한다.
    - 검색어를 포함하는 영화와 인물을 조회한다.
    - 영화는 개봉일 순으로 조회된다.
    - 인물은 이름순으로 조회된다.
예매
	- 예매는 회원만 가능하다.
	- 상영시간을 선택하면 인원을 선택하고, 인원수에 맞게 좌석을 선택하여 예매한다.
    - 인원은 성인과 청소년으로 나누어 선택한다.
    - 좌석은 예매되지 않은 죄석들을 선택한다.
    - 예매시 할인을 적용되지 않는다.
    - 12시 이전 상영되는 영화는 조조할인 금액으로 예매한다.
영화 관리 
	- 관리자는 상영 예정 또는 상영된 영화를 등록한다.
    - 영화 정보는 영화에 참여한 감독, 배우, 장르, 제목, 기본정보, 개봉일, 내용, 스틸컷, 트레일러, 영화 상세 정보를 입력하여 등록한다.
    - 감독/배우는 등록된 감독/배우 중에서 선택하여 입력하고, 여러명 입력이 가능하다.
    - 장르는 등록된 장르를 선택하며, 여러 장르 선택이 가능하다.
    - 기본 정보에서 연령은 등록된 연령 중 하나를 선택한다.
    - 기본 정보에서 러닝타임은 분단위로 정수로 입력한다.
    - 기본 정보에서 제작 국가는 등록된 국가 중 선택하며 여러 국가 선택이 가능하다.
    - 트레일러는 영상이며 여러 트레일러 등록이 가능하다.
    - 스틸컷은 이미지이며, 여러 스틸컷 등록이 가능하다.
감독/배우 관리
	- 관리자는 감독/배우를 등록, 수정, 삭제한다.
    - 감독/배우는 등록된 인물과 역할, 대표 사진을 선택하여 등록한다.
    - 한 영화인이 감독도 하고 배우도 했으면 각각 등록한다.
인물 관리
	- 관리자는 인물을 등록, 수정, 삭제한다.
    - 인물은 영화인의 정보로, 이름, 생년월일, 내용, 국가를 입력한다.
    - 국가는 대표 국가 하나만 선택한다.
극장 관리
  - 관리자는 극장을 등록, 수정, 삭제한다.
  - 극장은 지역, 이름, 상영관 정보, 주소(도로명), 총 관수를 입력한다. 
  - 지역은 등록된 지역 중 하나를 선택한다. 
  - 상영관 정보는 극장 등록과 함께 등록하거나 극장 등록 후 나중에 등록한다. 
상영관 관리
  - 관리자는 상영관을 등록, 수정, 삭제한다
  - 극장을 선택하고, 상영관 번호, 총 좌석수, 좌석 정보를 입력하여 등록한다. 
  - 상영관 번호는 해당 극장의 총 상영관 수보다 작거나 같아야 한다. 
  - 좌석 정보는 행은 영어 대문자로, 열은 숫자로 표현하여 해당 상영관의 모든 좌석를 등록한다. 
  - 등록된 좌석 정보에 맞게 총 좌석수를 저장한다.
  - 좌석은 상황에 따라 예매가 불가능하다. 
상영시간 관리
  - 관리자는 상영시간을 등록, 수정, 삭제한다.
  - 상영시간은 상영관 정보, 영화, 날짜, 상영시간을 입력하여 등록한다. 
  - 상영관 정보는 극장을 선택하면 상영관이 조회되고, 조회된 상영관 중 하나를 선택한다. 
  - 영화는 등록된 영화 중에서 하나를 선택한다. 
  - 상영시간은 10분 단위로 등록한다. 
요금 관리
  - 관리자는 요금을 수정한다.
  - 요금은 성인, 청소년, 조조할인으로 구분된다.
  - 청소년은 성인요금의 80%이다. */