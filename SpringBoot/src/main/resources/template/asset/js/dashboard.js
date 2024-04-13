
window.addEventListener('DOMContentLoaded', function() {

    window.addEventListener('resize', function() {
        var windowHeight = window.innerHeight - 3; 
        document.querySelector('.contain').style.height = windowHeight + 'px';
    });

    var initialWindowHeight = window.innerHeight - 3; 
    document.querySelector('.contain').style.height = initialWindowHeight + 'px';

    var item_task = document.querySelectorAll(".item-task");
    Array.from(item_task).forEach(function(item) {
        item.addEventListener("mouseover", function() {
            item.style.borderRadius = "20px";
            item.style.width = "75%";
        });
        item.addEventListener("mouseout", function() {
            item.style.borderRadius = "0px";
            item.style.width = "100%";
        });
    });
})
