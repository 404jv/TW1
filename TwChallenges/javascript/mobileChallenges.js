import { challenges as challengesTotal } from './challengesArray.js'

const challenges = challengesTotal.filter(c => c.platform === 'mobile');

const cardsDiv = document.querySelector('.Cards');

challenges.map((challenge => {
  const challengeDiv = document.createElement('div');
  challengeDiv.className = 'Card';

  const topCard = setTopCard(challenge);
  const bottomCard = setBottomCard(challenge);

  challengeDiv.appendChild(topCard);
  challengeDiv.appendChild(bottomCard);

  cardsDiv.appendChild(challengeDiv);
}));

function setTopCard(challenge) {
  const topCard = document.createElement('div');
  topCard.className = 'Top-Card';

  const challengeImg = document.createElement('img');
  challengeImg.className = 'FrontImage';
  challengeImg.src = 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTiBCVJvn5NWjrBS0zRK-6q3yV0uoeOuDoCchJ7648gwys_dhEc4QIuahHjWBD79mpfIkM&usqp=CAU';

  topCard.appendChild(challengeImg);

  challenge.tags.map(tag => {
    const tagDiv = document.createElement('span');
    tagDiv.className = `category-${tag}`
    tagDiv.innerText = tag;

    topCard.appendChild(tagDiv);
  });

  return topCard;
}

function setBottomCard(challenge) {
  const bottomCard = document.createElement('div');
  bottomCard.className = 'Bottom-Card';

  const title = document.createElement('h1');
  title.className = 'Title-Card';
  title.innerText = challenge.name;

  bottomCard.appendChild(title);

  const description = document.createElement('p');
  description.className = 'P-Card';
  description.innerText = `${challenge.description.substring(0, 80)}...`;

  bottomCard.appendChild(description);

  const linkToDetail = document.createElement('a');
  linkToDetail.className = 'Btn-Card';
  linkToDetail.text = 'Bora Codar!';
  linkToDetail.href = `/Pages/DesafioDetail.html?challenge_id=${challenge.id}`;

  bottomCard.appendChild(linkToDetail);

  return bottomCard;
}
