package com.arctouch.primeiroapp

import android.os.Bundle
import android.os.Parcelable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.sp
import androidx.navigation.Navigator
import androidx.versionedparcelable.VersionedParcelize
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Filme(
    val titulo: String,
    val descricao: String,
    val elenco: String,
) : Parcelable

@Composable
fun Homescreen(navController: NavHostController) {
        val filmes = listOf(

            Filme(
                "Poderoso Chefão",
                "\"O Poderoso Chefão\" é um clássico filme de drama e crime dirigido por Francis Ford Coppola, lançado em 1972. Baseado no livro de mesmo nome de Mario Puzo, o filme conta a história da família Corleone, liderada pelo patriarca Vito Corleone, interpretado por Marlon Brando. O filme explora temas como lealdade, vingança, poder e família, enquanto a família enfrenta desafios no submundo do crime organizado em Nova York. \"O Poderoso Chefão\" é aclamado pela crítica e é considerado um dos maiores filmes da história do cinema.",
                "O elenco:\n" +
                        "\n" +
                        "Marlon Brando como Vito Corleone\n" +
                        "Al Pacino como Michael Corleone\n" +
                        "James Caan como Santino \"Sonny\" Corleone\n" +
                        "Richard S. Castellano como Peter Clemenza\n" +
                        "Robert Duvall como Tom Hagen\n" +
                        "Sterling Hayden como Capitão McCluskey\n" +
                        "John Marley como Jack Woltz\n" +
                        "Richard Conte como Emilio Barzini\n" +
                        "Diane Keaton como Kay Adams\n" +
                        "Talia Shire como Connie Corleone"
            ),
            Filme(
                "Se Beber Não Case!",
                "\"Se Beber, Não Case!\" é uma comédia de 2009 dirigida por Todd Phillips. O filme segue um grupo de amigos - Phil, Stu, Alan e Doug - que viajam para Las Vegas para uma despedida de solteiro, mas acabam acordando sem memória da noite anterior e percebem que perderam o noivo, Doug, durante a noite. Eles então embarcam em uma jornada louca para encontrar Doug e reconstituir os eventos da noite anterior, encontrando uma série de situações hilárias e surpreendentes ao longo do caminho. O filme é conhecido por seu humor irreverente e momentos memoráveis, tornando-se um sucesso de bilheteria e gerando várias sequências.",
                "O elenco: \n" +
                        "Bradley Cooper como Phil Wenneck\n" +
                        "Ed Helms como Stu Price\n" +
                        "Zach Galifianakis como Alan Garner\n" +
                        "Justin Bartha como Doug Billings\n" +
                        "Heather Graham como Jade\n" +
                        "Jeffrey Tambor como Sid Garner\n" +
                        "Ken Jeong como Sr. Chow\n" +
                        "Rachael Harris como Melissa\n" +
                        "Mike Tyson como ele mesmo"
            ),
            Filme(
                "Mad Max: Estrada da Fúria",
                "\"Mad Max: Estrada da Fúria\" é um filme de ação pós-apocalíptico dirigido por George Miller e lançado em 2015. Ele segue a jornada de Max Rockatansky, interpretado por Tom Hardy, e Imperatriz Furiosa, interpretada por Charlize Theron, enquanto eles tentam escapar das garras do tirano Immortan Joe em um mundo desolado e árido. O filme é conhecido por suas cenas de ação frenéticas, sequências de perseguição espetaculares e cinematografia impressionante, e recebeu aclamação da crítica e vários prêmios, incluindo seis Oscars.",
                "O elenco:" +
                        "\n" +
                        "\n" +
                        "Tom Hardy como Max Rockatansky\n" +
                        "Charlize Theron como Imperatriz Furiosa\n" +
                        "Nicholas Hoult como Nux\n" +
                        "Hugh Keays-Byrne como Immortan Joe\n" +
                        "Josh Helman como Slit\n" +
                        "Rosie Huntington-Whiteley como The Splendid Angharad\n" +
                        "Riley Keough como Capable\n" +
                        "Zoe Kravitz como Toast the Knowing\n" +
                        "Abbey Lee como The Dag\n" +
                        "Courtney Eaton como Cheedo the Fragile"
            ),
            Filme(
                "Interstellar",
                "\"Interstellar\" é um épico de ficção científica dirigido por Christopher Nolan. O filme segue a jornada de Cooper, interpretado por Matthew McConaughey, e sua equipe em uma missão para encontrar um novo lar para a humanidade em um universo em colapso. Enquanto exploram o espaço, enfrentam desafios cósmicos e complexidades do tempo, tudo isso enquanto lidam com os laços emocionais entre pai e filha. O filme é elogiado por sua narrativa ambiciosa, efeitos visuais deslumbrantes e trilha sonora impactante.",
                "O elenco: \n" +
                        "\n" +
                        "Matthew McConaughey como Cooper\n" +
                        "Anne Hathaway como Amelia Brand\n" +
                        "Jessica Chastain como Murph (adulta)\n" +
                        "Mackenzie Foy como Murph (criança)\n" +
                        "Michael Caine como Professor Brand\n" +
                        "Casey Affleck como Tom (filho de Cooper)\n" +
                        "John Lithgow como Donald (pai de Cooper)\n" +
                        "Ellen Burstyn como Murph (idoso)\n" +
                        "Wes Bentley como Doyle\n" +
                        "David Gyasi como Romilly"
            ),
            Filme(
                "Toy Story", "\n" +
                        "\"Toy Story\" é um filme de animação lançado em 1995 pela Pixar Animation Studios, dirigido por John Lasseter. Ele conta a história de brinquedos que ganham vida quando seus donos não estão por perto. O filme segue a jornada de Woody, um cowboy de brinquedo, que se torna preocupado com seu lugar no coração de seu dono, Andy, quando um novo brinquedo, o astronauta Buzz Lightyear, chega à casa. A rivalidade inicial entre Woody e Buzz evolui para uma amizade improvável quando eles se unem para enfrentar desafios juntos.",
                "O elenco:\n" +
                        "\n" +
                        "Tom Hanks como Woody\n" +
                        "Tim Allen como Buzz Lightyear\n" +
                        "Don Rickles como Sr. Cabeça de Batata\n" +
                        "Jim Varney como Slinky Dog\n" +
                        "Wallace Shawn como Rex\n" +
                        "John Ratzenberger como Hamm\n" +
                        "Annie Potts como Betty\n" +
                        "John Morris como Andy\n" +
                        "Erik von Detten como Sid\n" +
                        "Laurie Metcalf como a Sra. Davis"
            ),
            Filme(
                "Harry Potter e a Pedra Filosofal",
                "\"Harry Potter e a Pedra Filosofal\" é o primeiro filme da série baseada nos livros de J.K. Rowling. Lançado em 2001, o filme segue a jornada de um jovem órfão chamado Harry Potter, que descobre que é um bruxo famoso e é convidado a frequentar a Escola de Magia e Bruxaria de Hogwarts. Lá, ele faz amizade com Ron Weasley e Hermione Granger, e juntos eles investigam mistérios relacionados a uma pedra lendária que concede imortalidade.\n" + "\n",
                "O elenco:\n" +
                        "\n" +
                        "Daniel Radcliffe como Harry Potter\n" +
                        "Rupert Grint como Ron Weasley\n" +
                        "Emma Watson como Hermione Granger\n" +
                        "Richard Harris como Alvo Dumbledore\n" +
                        "Maggie Smith como Minerva McGonagall\n" +
                        "Robbie Coltrane como Rubeus Hagrid\n" +
                        "Alan Rickman como Severo Snape\n" +
                        "Tom Felton como Draco Malfoy\n" +
                        "Ian Hart como Quirinus Quirrell\n" +
                        "Richard Griffiths como Válter Dursley"
            ),
            Filme(
                "O Silêncio dos Inocentes",
                "\"O Silêncio dos Inocentes\" é um thriller psicológico lançado em 1991, dirigido por Jonathan Demme e baseado no romance homônimo de Thomas Harris. O filme acompanha a história de Clarice Starling, uma jovem e talentosa agente do FBI, que é designada para entrevistar o brilhante, mas psicopata, Dr. Hannibal Lecter. O objetivo de Starling é obter informações sobre outro assassino em série conhecido como Buffalo Bill, que sequestra e mata jovens mulheres.",
                " O elenco:\n" +
                        "Jodie Foster como Clarice Starling\n" +
                        "Anthony Hopkins como Dr. Hannibal Lecter\n" +
                        "Scott Glenn como Jack Crawford\n" +
                        "Ted Levine como Buffalo Bill\n" +
                        "Anthony Heald como Dr. Frederick Chilton\n" +
                        "Brooke Smith como Catherine Martin\n" +
                        "Diane Baker como Senadora Ruth Martin"
            ),
            Filme(
                "Diário de uma Paixão",
                "\"Diário de uma Paixão\" é um filme romântico lançado em 2004, dirigido por Nick Cassavetes e baseado no romance de mesmo nome escrito por Nicholas Sparks. O filme conta a história de amor entre Allie Hamilton e Noah Calhoun, que se conheceram durante o verão de 1940 na Carolina do Sul, Estados Unidos. Embora sejam de origens sociais diferentes, eles se apaixonam profundamente. No entanto, as circunstâncias os separam.\n" + "\n",
                "O elenco:" + "\n" +
                        "\n" +
                        "Ryan Gosling como Noah Calhoun (jovem)\n" +
                        "Rachel McAdams como Allie Hamilton (jovem)\n" +
                        "James Garner como Noah Calhoun (idoso)\n" +
                        "Gena Rowlands como Allie Hamilton (idoso)\n" +
                        "Joan Allen como Anne Hamilton\n" +
                        "James Marsden como Lon Hammond Jr.\n" +
                        "Sam Shepard como Frank Calhoun\n" +
                        "David Thornton como John Hamilton\n" +
                        "Kevin Connolly como Fin\n" +
                        "Jamie Brown como Martha Shaw"
            ),
            Filme(
                "La La Land: Cantando Estações", "\n" +
                        "\"La La Land: Cantando Estações\" é um musical romântico dirigido por Damien Chazelle, lançado em 2016. O filme segue a história de amor entre Mia Dolan, uma aspirante a atriz, e Sebastian Wilder, um talentoso pianista de jazz, enquanto eles perseguem seus sonhos em Los Angeles. Enquanto enfrentam desafios e adversidades em suas carreiras e relacionamento, eles descobrem o verdadeiro significado do amor e da perseverança.",
                "O elenco:\n" +
                        "\n" +
                        "Ryan Gosling como Sebastian Wilder\n" +
                        "Emma Stone como Mia Dolan\n" +
                        "John Legend como Keith\n" +
                        "Rosemarie DeWitt como Laura Wilder\n" +
                        "J.K. Simmons como Bill\n" +
                        "Finn Wittrock como Greg\n" +
                        "Tom Everett Scott como David\n" +
                        "Callie Hernandez como Tracy\n" +
                        "Jessica Rothe como Alexis\n" +
                        "Sonoya Mizuno como Caitlin"
            ),
            Filme(
                "A Marcha dos Pingüins",
                "\"A Marcha dos Pingüins\" é um documentário emocionante que retrata a jornada extraordinária dos pinguins-imperadores na Antártida. Narrado por Morgan Freeman na versão em inglês, o filme mostra a incrível luta pela sobrevivência dessas aves durante sua migração anual para o local de reprodução, o desafio de incubação dos ovos e o cuidado com os filhotes em um ambiente extremamente hostil. Com imagens deslumbrantes e uma narrativa envolvente, o documentário cativa o público ao revelar a beleza e a determinação dessas criaturas incríveis.",
                "Em documentários, não há um elenco de atores tradicionais, já que o filme é uma representação da vida real. No entanto, na versão em inglês de \"A Marcha dos Pingüins\", Morgan Freeman emprestou sua voz para a narração, fornecendo uma voz envolvente e informativa para o documentário. Portanto, ele é frequentemente associado ao filme como o narrador na versão em inglês. Fora isso, não há elenco de atores como em filmes de ficção, já que o filme se concentra na vida selvagem e na observação da natureza."
            ),
        )

        Column {
            for (filme in filmes)
                ClickableText(
                    text = AnnotatedString(filme.titulo),
                    onClick = {
                        navController.currentBackStackEntry?.savedStateHandle?.set("filme", filme)
                        navController.navigate("detalhes")
                    },
                )
        }


}













