import { challenges } from './challengesArray.js'

function getChallengeId() {
    try {
      const urlString = window.location.href.toLowerCase();
      const url = new URL(urlString);
  
      const challenge_id = url.searchParams.get('challenge_id');
      
      return challenge_id;
    } catch (error) {
      console.log(error);
    }
  }

const challenge_id = getChallengeId();

let challenge = challenges.find(c => c.id == challenge_id);

if (!challenge) {
    challenge = challenges[0];
}

const totalImages = challenge.imagesLinks.length;

let image = document.querySelector('#active');
image.src = challenge.imagesLinks[0];

let active = 1;

let next = document.getElementById('Arrow-R');
let previous = document.getElementById('Arrow-L');


next.addEventListener('click', () => {
    NextSlide();
    console.log(active)
    image.src = challenge.imagesLinks[active];
})

previous.addEventListener('click', () => {
    PreviousSlide();
    console.log(active)
    image.src = challenge.imagesLinks[active];
})

function NextSlide(){
    if(active === totalImages - 1){
        active = 0;
    }else{
        active++;
    }
}

function PreviousSlide(){
    if(active <= 0){
        active = totalImages - 1;
    }else{
        active--;
    }
}
