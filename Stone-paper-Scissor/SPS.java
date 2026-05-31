let userScore = 0;
let compScore = 0;

const choices = document.querySelectorAll(".choice");   // apne div ke sare choice ko select kia
const msg = document.querySelector("#msg");  // aone msg ko chng krne ke liye select kia phle

const userScorepara = document.querySelector("#user-score");
const compScorepara = document.querySelector("#comp-score");

const GenCompchoice = () => {
    const options = ["rock", "paper", "scissor"];
    const ranIdx = Math.floor(Math.random() * 3)// isse ham koi bhi random no. choose kra skte h ye koi bhi no. choose krega ab 3 se mul m vo 0 se 2 ke beech ke no. dega mtlb jisse bhi mul kre usse ek kam tk no. dega and math.floor se decimal no. ni ayege
    return options[ranIdx];
}

const drawGame = () => { // draw game func bnya agr draw hua to ye print
    console.log("game was draw");
    msg.innerText = "game was draw . play again";
    msg.style.backgroundColor = "#081b31";
}

const showWinner = (userWin, userchoice, compchoice) => {
    if (userWin) {   // agr userwin true to jeet gye ni to false to har gye
        userScore++;
        userScorepara.innerText = userScore;
        msg.innerText = `you win! your ${userchoice} beats ${compchocie}`; // agr jeet gya to apne text ko print krayege ki u win ni to u lose
        msg.style.backgroundColor = "green";   //agr jeete to backgroundColor green 
    } else {
        compScore++;
        compScorepara.innerText = compScore;
        msg.innerText = `you lost. ${compchoice} beats your ${userchoice}`;
        msg.style.backgroundColor = "red";  // hare to red
    }
};
const playGame = (userchoice) => {
    const compchoice = GenCompchoice();

    if (userchoice == compchoice) { // agr dono ki same choice to darwgame fun hua
        drawGame();
    } else {
        let userWin = true; // assume kia ki userwin h to true
        if (userchoice == "rock") {
            userWin = compchoice == paper ? false : true; // agr userki choice rock h and comp ki chpice paper to userwin false ho jayega bcz vo har gy and comp win and agr paper ni h comp ki chocie to bcha scissor to usme user jeet jayega to true vhi likha h ahr paper to false ni to true
        } else if (userchoice == "paper") { // agr user ki choice paoer h to comp ki choice paper to hogi ni bcz draw hojayega usme to to ab ya to roc ya scissor h compchocie
            userWin = compchoice == rock ? true : false; // agr comp ki chocie rock to user jeet gya to true ni scissor to comp jeet gya and userwin false
        } else { // ab to user kw pass last choice scissor bchi h to comp ki chocie ya to paper ya rock hoga scissor m to draw game
            userWin = compchoice == paper ? true : false;
        }

        showWinner(userWin, userchoice, compchoice); // ab show winner m apne userwin ko pass kr skte ki user jeeta ki ni
    }
}

choices.forEach((choice) => { // isse hamre div ki sari choice ek ek krke ayegi
    console.log(choice);
    choice.addEventListener("click", () => { // apne div ke har choice ko clickable bnya h jo click ko track krega and usme ye func call hoga  jaise hi ham apne div ko ya choice ko click kre to ye kam perform ho
        const userchoice = choice.getAttribute("id") // ham apni choice ki id ko bhi check kr skte h ki konsi id h rock paper ya scissor
        playGame(userchoice);

    })
})
