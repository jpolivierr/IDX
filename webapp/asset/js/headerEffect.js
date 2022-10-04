// Header background effect
(headerEffect =(headerClass) =>{
    let header =  document.querySelector(`${headerClass}`)
    let menu = document.querySelector('menu')
    window.onscroll = function(){
        "use strict";
    if (document.body.scrollTop >= 76 || document.documentElement.scrollTop >= 76) {
        menu.classList.add("menu-color")
        header.classList.add("bk-alt");
        header.classList.add("border-bottom");
        header.classList.add("main-shadow");
        header.classList.remove("bk-transparent");
    } else {
        
        header.classList.add("bk-transparent");
        header.classList.remove("border-bottom");
        header.classList.remove("bk-alt");
        menu.classList.remove("menu-color");
        header.classList.remove("main-shadow");
    }
    }
})(".av-header-v1");