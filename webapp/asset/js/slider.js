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
        this.blockWidth = (this.Window.offsetWidth / 4.19).toFixed(0)
        this.containerWidth = (this.container.offsetWidth).toFixed(0)
        const gap = (this.containerWidth - (this.blockWidth * this.blockCount)) / (this.blockCount -1)
        const count = (-this.blockWidth - gap) + this.position
        this.position = Number(count.toFixed(2))
        this.container.style.left = `${this.position.toFixed(0)}px`


        this.hideCtlBtn()
    }

    prev(){
        this.windowWidth = this.Window.offsetWidth
        this.blockWidth = (this.Window.offsetWidth / 4.19).toFixed(0)
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

    addBlockWidth(){
        !this.Window.querySelector('style') ? null : this.Window.querySelector('style').remove()

        let mainWith = document.querySelector('.av-slider-window').offsetWidth.toFixed(2)
        const blockWidth = (mainWith / 4.19).toFixed(2)
        const style = document.createElement('style');
        console.log(mainWith)
        style.textContent = `
            .slider-block{
                width: ${blockWidth}px
            }
        `
        // style.textContent = `
        //     .slider-block{
        //         width: ${(mainWith / 4.12).toFixed(0)}px
        //     }
        // `
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