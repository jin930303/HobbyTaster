 function updateSubCategory() {
            // 대분류 선택 값 가져오기
            const cat1 = document.getElementById('cat1').value;
            const cat2 = document.getElementById('cat2');

            // 중분류 초기화
            cat2.innerHTML = '<option value="">-- 중분류 선택 --</option>';

            // 대분류에 따른 중분류 옵션 설정
            let options = [];
            if (cat1 === '공예') {
                options = ['도예', '인형', '쥬얼리'];
            } else if (cat1 === '예술') {
                options = ['드로잉', '사진', '음악'];
            } else if (cat1 === '베이킹') {
                options = ['쿠키', '케이크', '빵'];
            } else if (cat1 === '주류') {
                options = ['와인', '맥주', '전통주'];
            }

            // 중분류 옵션 추가
            options.forEach(option => {
                const opt = document.createElement('option');
                opt.value = option;
                opt.textContent = option;
                cat2.appendChild(opt);
            });
        }