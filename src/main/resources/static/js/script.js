
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
