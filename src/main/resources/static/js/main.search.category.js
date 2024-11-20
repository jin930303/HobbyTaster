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

