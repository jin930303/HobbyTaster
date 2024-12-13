// 1. 카테고리1 선택 시 카테고리2가 내려옴
    function showSubCategory(categoryId) {
        // 모든 하위 카테고리를 숨김 처리
        const subCategories = document.querySelectorAll('.sub-category');
        subCategories.forEach(subCategory => {
            subCategory.style.display = 'none';
        });

        // 선택된 대분류의 하위 카테고리만 표시
        const selectedCategory = document.getElementById(categoryId);
        if (selectedCategory) {
            selectedCategory.style.display = 'block';
        }
    }

// 2. 검색창 숨김
    // DOMContentLoaded = HTML 문서가 완전히 로드되고 파싱될 때 발생
    // addEventListener = handler(이벤트 발생 시 실행할 함수)를 등록하는 메서드
    // () => = ArrowFunction 으로 이벤트 발생 시 실행 됨을 의미함
    document.addEventListener("DOMContentLoaded", () => {
    // const = 변수 선언 키워드
    // document = 객체 제어/조작 기능하는 최상위 객체
    // getElementById = id 가져오기
      const clickSearch = document.getElementById("click_search_input");
      const hiddenSearch = document.getElementById("hidden-search");

      // 초기 검색창 클릭 시 확장 검색창 활성화
    // clickSearch 를 "click" 이벤트가 작동하면 addEventListener 에 의해서 ()=> 으로 이벤트가 실행됨.
    // hiddenSearch 에서 classList.add() 메서드를 통해 "active" 클래스를 추가한다.
      clickSearch.addEventListener("click", () => {
        hiddenSearch.classList.add("active");
      });

      // 외부 클릭 시 확장 검색창 숨기기 (선택 사항)
    // "click" 이벤트를 등록
    // contains(e.target) = target 된 포인트가 부모요소인지 구분
      document.addEventListener("click", (e) => {
        if (!hiddenSearch.contains(e.target) && e.target !== clickSearch) {
          hiddenSearch.classList.remove("active");
        }
      });
    });