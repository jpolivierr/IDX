class Slider{
    constructor(){
        this.Window = document.querySelector('.av-slider-window')
        this.container = document.querySelector('.av-slider-container')
        this.prevNext = document.querySelector('.av-slider-next')
        this.prevPrev = document.querySelector('.av-slider-prev')
        this.windowWidth = null
        this.containerWidth = null 
        this.blockWidth = null
        this.blockCount = document.querySelectorAll('.slider-block').length
        this.gap = null
        this.position = 0
        this.frac = 4.15;
        this.init()
    }

    registerListeners(){
        this.prevNext.addEventListener('click',()=>{
            this.next()
        })
        this.prevPrev.addEventListener('click',()=>{
            this.prev()
        })
    }

    next(){ 
        this.windowWidth = this.Window.offsetWidth
        this.blockWidth = (this.Window.offsetWidth / this.frac ).toFixed(0)
        this.containerWidth = (this.container.offsetWidth).toFixed(0)
        
        const gap = (this.containerWidth - (this.blockWidth * this.blockCount)) / (this.blockCount -1)

        const count = (-this.blockWidth - gap) + this.position

        this.position = Number(count.toFixed(2))
        this.container.style.left = `${this.position.toFixed(0)}px`


        this.hideCtlBtn()
    }

    prev(){
        this.windowWidth = this.Window.offsetWidth
        this.blockWidth = (this.Window.offsetWidth / this.frac ).toFixed(0)
        this.containerWidth = (this.container.offsetWidth).toFixed(0)
        const gap = (this.containerWidth - (this.blockWidth * this.blockCount)) / (this.blockCount -1)

        const count = (+this.blockWidth + gap) + this.position
        this.position = Number(count.toFixed(2))
        this.container.style.left = `${this.position.toFixed(0)}px` 

        this.hideCtlBtn()
    }

    hideCtlBtn(){
        const totalBlockWidth = this.blockWidth * this.blockCount
        const remainingBlock = Number(this.containerWidth) + (this.position.toFixed(0) - (Number(this.windowWidth)))
        console.log(this.position)

        if(Number(this.position) < 0){
            this.prevPrev.style.display = 'flex'
        }else{
            this.prevPrev.style.display = 'none'
        }

        if(Number(remainingBlock) < 10 && remainingBlock !== 0){
            this.prevNext.style.display = 'none'
        }else{
            this.prevNext.style.display = 'flex'
        }
    }

    resizeOnScreenEvent(){
        this.container.classList.add("position-left")
        this.position = 0
        this.container.style.left = 0
         if(window.innerWidth > 1202){
            this.frac = 4.19
        }
        if(window.innerWidth <= 1202){
            this.frac = 3.10
        }
        if(window.innerWidth >= 1501){
                    this.frac = 4.12
                }

        if(window.innerWidth <= 966){
            this.frac = 3.14
        }
        if(window.innerWidth <= 832){
            this.frac = 2.05
        }
        if(window.innerWidth <= 620){
            this.frac = 1.5
        }
    }

    addBlockWidth(){
         
        this.resizeOnScreenEvent()
       
        !this.Window.querySelector('style') ? null : this.Window.querySelector('style').remove()
       
        let mainWith = document.querySelector('.av-slider-window').offsetWidth.toFixed(2)
        const blockWidth = (mainWith / this.frac).toFixed(2)
        const style = document.createElement('style');
        
        style.textContent = `
            .slider-block{
                width: ${blockWidth}px
            }
        `
        this.Window.appendChild(style)
    }

    resizeWindow (){
        this.addBlockWidth()
        window.addEventListener('resize', ()=>{
            this.addBlockWidth()
        });
    }


    init(){
        this.hideCtlBtn()
        this.registerListeners()
        this.resizeWindow()
    }
}

new Slider()