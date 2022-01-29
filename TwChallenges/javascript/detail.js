import { challenges } from './challengesArray.js'

const infoContainer = document.querySelector('.InfoContainer');

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

setInfoContainer();

function setInfoContainer() {
  const title = document.createElement('h2');
  title.className = 'h2-Info';
  title.innerText = challenge.name;

  infoContainer.appendChild(title);

  const description = document.createElement('p');
  description.className = 'p-Info';
  description.innerText = challenge.description;

  infoContainer.appendChild(description);

  const tagsContainer = document.createElement('div');
  tagsContainer.className = 'Category-Info';

  challenge.tags.map(tag => {
    const tagDiv = document.createElement('span');
    tagDiv.className = `category-${tag}`
    tagDiv.innerText = tag;

    tagsContainer.appendChild(tagDiv);
  });

  infoContainer.appendChild(tagsContainer);

  const linkToGithub = document.createElement('a');
  linkToGithub.className = 'Btn-Info';
  linkToGithub.textContent = 'Abrir no GitHub'
  linkToGithub.target = '_blank'
  linkToGithub.href = challenge.github_link;

  infoContainer.appendChild(linkToGithub);

  const titleH2 = document.querySelector('.h2-title-challenge');
  titleH2.innerText = `Desafio ${challenge.name}`;

  const description2 = document.querySelector('.p-description-challenge');
  description2.innerText = challenge.description;
}
