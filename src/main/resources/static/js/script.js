
    function toggleSidebar() {
        var sidebar = document.getElementById("sidebar");
        if (sidebar.style.display === "block") {
            sidebar.style.display = "none";
        } else {
            sidebar.style.display = "block";
        }
    }

    function isMobileDevice() {
        return (typeof window.orientation !== "undefined") || (navigator.userAgent.indexOf('IEMobile') !== -1);
    }

    // Если на мобильном устройстве, добавляем обработчик клика для перехода на новую страницу
    if (isMobileDevice()) {
        const listItems = document.querySelectorAll('.list-group-item');

        listItems.forEach(item => {
            item.addEventListener('click', function() {
                const itemId = item.getAttribute('href');
                window.location.href = itemId; // Переход на новую страницу
            });
        });
    }

    document.addEventListener('DOMContentLoaded', function () {
            const descriptions = document.querySelectorAll('.post-description');
            const toggles = document.querySelectorAll('.btn-toggle-description');

            descriptions.forEach(function (description, index) {
                const text = description.textContent;
                if (text.length > 300) {
                    const truncatedText = text.slice(0, 300) + '...';
                    description.dataset.fullText = text;
                    description.textContent = truncatedText;
                    toggles[index].style.display = 'block';
                }
            });

            toggles.forEach(function (toggle, index) {
                toggle.addEventListener('click', function () {
                    const description = descriptions[index];
                    const text = description.textContent;
                    const fullText = description.dataset.fullText;
                    if (text.length > 300) {
                        const isTruncated = text.endsWith('...');
                        if (isTruncated) {
                            description.textContent = fullText;
                            toggle.textContent = 'Скрыть';
                        } else {
                            const truncatedText = text.slice(0, 300) + '...';
                            description.textContent = truncatedText;
                            toggle.textContent = 'Показать больше';
                        }
                    }
                });
            });
        });
