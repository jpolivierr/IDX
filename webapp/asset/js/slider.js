class Slider{
    constructor(){
        this.Window = document.querySelector('.av-slider-window')
        this.container = document.querySelector('.av-slider-container')
        this.prevNext = document.querySelector('.av-slider-next')
        this.prevPrev = document.querySelector('.av-slider-prev')
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
        
        this.blockWidth = (this.Window.offsetWidth / 4.19).toFixed(2)
        this.containerWidth = (this.container.offsetWidth).toFixed(2)
        const gap = (this.containerWidth - (this.blockWidth * this.blockCount)) / (this.blockCount - 1)

        this.position = - this.blockWidth + this.position
        this.container.style.left = `${this.position - gap}px`

        const totalBlockWidth = this.blockWidth * this.blockCount
        const totalWindowWidth = this.Window.offsetWidth
        const totalGap = (this.blockWidth * this.blockCount) / this.blockCount
        console.log(totalGap)
    console.log((this.position.toFixed(2) - (Number(this.containerWidth))) + totalBlockWidth )
        this.hideCtlBtn()
    }

    prev(){
        
        this.blockWidth = (this.Window.offsetWidth / 4.19).toFixed(2)
        this.containerWidth = (this.container.offsetWidth).toFixed(2)
        const gap = (this.containerWidth - (this.blockWidth * this.blockCount)) / this.blockCount
        this.position = +this.blockWidth + this.position
        this.container.style.left = `${this.position.toFixed(2)}px` 

        const totalBlockWidth = this.blockWidth * this.blockCount
        const totalWindowWidth = this.Window.offsetWidth

        console.log(`Position : ${this.position.toFixed(2)}`)
        console.log(`total block width: ${totalBlockWidth.toFixed(2)}`)
        console.log(`total slider width: ${totalWindowWidth}`)

        console.log(this.position.toFixed(2))
        this.hideCtlBtn()
    }

    hideCtlBtn(){
        if(Number(this.position) < 0){
            this.prevPrev.style.display = 'flex'
        }else{
            this.prevPrev.style.display = 'none'
        }

        if(Number(this.position) >= 0){
            this.prevNext.style.display = 'flex'
        }else{
            this.prevNext.style.display = 'flex'
        }
    }

    addBlockWidth(){
        !this.Window.querySelector('style') ? null : this.Window.querySelector('style').remove()

        let mainWith = document.querySelector('.av-slider-window').offsetWidth
        const style = document.createElement('style');
        style.textContent = `
            .slider-block{
                width: ${(mainWith / 4.19).toFixed(2)}px
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