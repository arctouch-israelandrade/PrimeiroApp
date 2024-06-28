package com.arctouch.primeiroapp

import android.os.Parcelable
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Filme(
    val titulo: String,
    val descricao: String,
    val elenco: List<String>,
) : Parcelable

@Composable
fun Homescreen(navController: NavHostController) {

    val emojiCamera = "\uD83C\uDFA5"

    val filmes = listOf(

        Filme(
            " $emojiCamera Poderoso Chefão",
            "\"O Poderoso Chefão\" é um clássico filme de drama e crime dirigido por Francis Ford Coppola, lançado em 1972. Baseado no livro de mesmo nome de Mario Puzo, o filme conta a história da família Corleone, liderada pelo patriarca Vito Corleone, interpretado por Marlon Brando. O filme explora temas como lealdade, vingança, poder e família, enquanto a família enfrenta desafios no submundo do crime organizado em Nova York. \"O Poderoso Chefão\" é aclamado pela crítica e é considerado um dos maiores filmes da história do cinema.",
            listOf(
                "Marlon Brando como Vito Corleone",
                "Al Pacino como Michael Corleone",
                "James Caan como Santino \"Sonny\" Corleone",
                "Richard S. Castellano como Peter Clemenza",
                "Robert Duvall como Tom Hagen",
                "Sterling Hayden como Capitão McCluskey",
                "John Marley como Jack Woltz",
                "Richard Conte como Emilio Barzini",
                "Diane Keaton como Kay Adams",
                "Talia Shire como Connie Corleone"
            )
        ),
        Filme(
            " $emojiCamera Se Beber Não Case!",
            "\"Se Beber, Não Case!\" é uma comédia de 2009 dirigida por Todd Phillips. O filme segue um grupo de amigos - Phil, Stu, Alan e Doug - que viajam para Las Vegas para uma despedida de solteiro, mas acabam acordando sem memória da noite anterior e percebem que perderam o noivo, Doug, durante a noite. Eles então embarcam em uma jornada louca para encontrar Doug e reconstituir os eventos da noite anterior, encontrando uma série de situações hilárias e surpreendentes ao longo do caminho. O filme é conhecido por seu humor irreverente e momentos memoráveis, tornando-se um sucesso de bilheteria e gerando várias sequências.",
            listOf(
                "Bradley Cooper como Phil Wenneck",
                "Ed Helms como Stu Price",
                "Zach Galifianakis como Alan Garner",
                "Justin Bartha como Doug Billings",
                "Heather Graham como Jade",
                "Jeffrey Tambor como Sid Garner",
                "Ken Jeong como Sr. Chow",
                "Rachael Harris como Melissa",
                "Mike Tyson como ele mesmo"
            )
        ),
        Filme(
            "$emojiCamera Mad Max: Estrada da Fúria",
            "\"Mad Max: Estrada da Fúria\" é um filme de ação pós-apocalíptico dirigido por George Miller e lançado em 2015. Ele segue a jornada de Max Rockatansky, interpretado por Tom Hardy, e Imperatriz Furiosa, interpretada por Charlize Theron, enquanto eles tentam escapar das garras do tirano Immortan Joe em um mundo desolado e árido. O filme é conhecido por suas cenas de ação frenéticas, sequências de perseguição espetaculares e cinematografia impressionante, e recebeu aclamação da crítica e vários prêmios, incluindo seis Oscars.",
            listOf(
                "Tom Hardy como Max Rockatansky",
                "Charlize Theron como Imperatriz Furiosa",
                "Nicholas Hoult como Nux",
                "Hugh Keays-Byrne como Immortan Joe",
                "Josh Helman como Slit",
                "Rosie Huntington-Whiteley como The Splendid Angharad",
                "Riley Keough como Capable",
                "Zoe Kravitz como Toast the Knowing",
                "Abbey Lee como The Dag",
                "Courtney Eaton como Cheedo the Fragile"
            )

        ),
        Filme(
            "$emojiCamera Interstellar",
            "\"Interstellar\" é um épico de ficção científica dirigido por Christopher Nolan. O filme segue a jornada de Cooper, interpretado por Matthew McConaughey, e sua equipe em uma missão para encontrar um novo lar para a humanidade em um universo em colapso. Enquanto exploram o espaço, enfrentam desafios cósmicos e complexidades do tempo, tudo isso enquanto lidam com os laços emocionais entre pai e filha. O filme é elogiado por sua narrativa ambiciosa, efeitos visuais deslumbrantes e trilha sonora impactante.",
            listOf(
                "Matthew McConaughey como Cooper",
                "Anne Hathaway como Amelia Brand",
                "Jessica Chastain como Murph (adulta)",
                "Mackenzie Foy como Murph (criança)",
                "Michael Caine como Professor Brand",
                "Casey Affleck como Tom (filho de Cooper)",
                "John Lithgow como Donald (pai de Cooper)",
                "Ellen Burstyn como Murph (idoso)",
                "Wes Bentley como Doyle",
                "David Gyasi como Romilly"
            )
        ),
        Filme(
            "$emojiCamera Toy Story",
            "\n" + "\"Toy Story\" é um filme de animação lançado em 1995 pela Pixar Animation Studios, dirigido por John Lasseter. Ele conta a história de brinquedos que ganham vida quando seus donos não estão por perto. O filme segue a jornada de Woody, um cowboy de brinquedo, que se torna preocupado com seu lugar no coração de seu dono, Andy, quando um novo brinquedo, o astronauta Buzz Lightyear, chega à casa. A rivalidade inicial entre Woody e Buzz evolui para uma amizade improvável quando eles se unem para enfrentar desafios juntos.",
            listOf(
                "Tom Hanks como Woody",
                "Tim Allen como Buzz Lightyear",
                "Don Rickles como Sr. Cabeça de Batata",
                "Jim Varney como Slinky Dog",
                "Wallace Shawn como Rex",
                "John Ratzenberger como Hamm",
                "Annie Potts como Betty",
                "John Morris como Andy",
                "Erik von Detten como Sid",
                "Laurie Metcalf como a Sra. Davis"
            )
        ),
        Filme(
            "$emojiCamera Harry Potter e a Pedra Filosofal",
            "\"Harry Potter e a Pedra Filosofal\" é o primeiro filme da série baseada nos livros de J.K. Rowling. Lançado em 2001, o filme segue a jornada de um jovem órfão chamado Harry Potter, que descobre que é um bruxo famoso e é convidado a frequentar a Escola de Magia e Bruxaria de Hogwarts. Lá, ele faz amizade com Ron Weasley e Hermione Granger, e juntos eles investigam mistérios relacionados a uma pedra lendária que concede imortalidade.\n" + "\n",
            listOf(
                "Daniel Radcliffe como Harry Potter",
                "Rupert Grint como Ron Weasley",
                "Emma Watson como Hermione Granger",
                "Richard Harris como Alvo Dumbledore",
                "Maggie Smith como Minerva McGonagall",
                "Robbie Coltrane como Rubeus Hagrid",
                "Alan Rickman como Severo Snape",
                "Tom Felton como Draco Malfoy",
                "Ian Hart como Quirinus Quirrell",
                "Richard Griffiths como Válter Dursley"
            )
        ),
        Filme(
            "$emojiCamera O Silêncio dos Inocentes",
            "\"O Silêncio dos Inocentes\" é um thriller psicológico lançado em 1991, dirigido por Jonathan Demme e baseado no romance homônimo de Thomas Harris. O filme acompanha a história de Clarice Starling, uma jovem e talentosa agente do FBI, que é designada para entrevistar o brilhante, mas psicopata, Dr. Hannibal Lecter. O objetivo de Starling é obter informações sobre outro assassino em série conhecido como Buffalo Bill, que sequestra e mata jovens mulheres.",
            listOf(
                "Jodie Foster como Clarice Starling",
                "Anthony Hopkins como Dr. Hannibal Lecter",
                "Scott Glenn como Jack Crawford\n" + "Ted Levine como Buffalo Bill",
                "Anthony Heald como Dr. Frederick Chilton\n" + "Brooke Smith como Catherine Martin",
                "Diane Baker como Senadora Ruth Martin"
            )
        ),
        Filme(
            "$emojiCamera Diário de uma Paixão",
            "\"Diário de uma Paixão\" é um filme romântico lançado em 2004, dirigido por Nick Cassavetes e baseado no romance de mesmo nome escrito por Nicholas Sparks. O filme conta a história de amor entre Allie Hamilton e Noah Calhoun, que se conheceram durante o verão de 1940 na Carolina do Sul, Estados Unidos. Embora sejam de origens sociais diferentes, eles se apaixonam profundamente. No entanto, as circunstâncias os separam.\n" + "\n",
            listOf(
                "Ryan Gosling como Noah Calhoun (jovem)",
                "Rachel McAdams como Allie Hamilton (jovem)",
                "James Garner como Noah Calhoun (idoso)",
                "Gena Rowlands como Allie Hamilton (idoso)",
                "Joan Allen como Anne Hamilton",
                "James Marsden como Lon Hammond Jr.",
                "Sam Shepard como Frank Calhoun",
                "David Thornton como John Hamilton",
                "Kevin Connolly como Fin",
                "Jamie Brown como Martha Shaw"
            )
        ),
        Filme(
            "$emojiCamera La La Land: CantandoEstações",
            "\n" + "\"La La Land: Cantando Estações\" é um musical romântico dirigido por Damien Chazelle, lançado em 2016. O filme segue a história de amor entre Mia Dolan, uma aspirante a atriz, e Sebastian Wilder, um talentoso pianista de jazz, enquanto eles perseguem seus sonhos em Los Angeles. Enquanto enfrentam desafios e adversidades em suas carreiras e relacionamento, eles descobrem o verdadeiro significado do amor e da perseverança.",
            listOf(
                "Ryan Gosling como Sebastian Wilder",
                "Emma Stone como Mia Dolan",
                "John Legend como Keith",
                "Rosemarie DeWitt como Laura Wilder",
                "J.K. Simmons como Bill",
                "Finn Wittrock como Greg",
                "Tom Everett Scott como David",
                "Callie Hernandez como Tracy",
                "Jessica Rothe como Alexi",
                "Sonoya Mizuno como Caitlin"
            )
        ),
        Filme(
            "$emojiCamera A Marcha dos Pingüins",
            "\"A Marcha dos Pingüins\" é um documentário emocionante que retrata a jornada extraordinária dos pinguins-imperadores na Antártida. Narrado por Morgan Freeman na versão em inglês, o filme mostra a incrível luta pela sobrevivência dessas aves durante sua migração anual para o local de reprodução, o desafio de incubação dos ovos e o cuidado com os filhotes em um ambiente extremamente hostil. Com imagens deslumbrantes e uma narrativa envolvente, o documentário cativa o público ao revelar a beleza e a determinação dessas criaturas incríveis",
            listOf("Em documentários, não há um elenco de atores tradicionais, já que o filme é uma representação da vida real. No entanto, na versão em inglês de \"A Marcha dos Pingüins\", Morgan Freeman emprestou sua voz para a narração, fornecendo uma voz envolvente e informativa para o documentário. Portanto, ele é frequentemente associado ao filme como o narrador na versão em inglês. Fora isso, não há elenco de atores como em filmes de ficção, já que o filme se concentra na vida selvagem e na observação da natureza.")
        ),
    )


    LazyColumn {
        items(filmes) { filme ->
            Text(text = filme.titulo, modifier = Modifier
                .clickable {
                    navController.currentBackStackEntry?.savedStateHandle?.set(
                        "filme", filme
                    )
                    navController.navigate(DETALHES)
                }
                .padding(16.dp))
        }


    }
}













