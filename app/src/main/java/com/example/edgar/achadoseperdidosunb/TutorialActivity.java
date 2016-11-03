package com.example.edgar.achadoseperdidosunb;

import android.content.Intent;
import android.view.View;

import com.luseen.verticalintrolibrary.VerticalIntro;
import com.luseen.verticalintrolibrary.VerticalIntroItem;

/**
 * Created by edgar on 02/11/2016.
 */

public class TutorialActivity extends VerticalIntro{
    @Override
    protected void init() {
        addIntroItem(new VerticalIntroItem.Builder()
                .backgroundColor(R.color.colorAccent)
                .image(R.drawable.lupa)
                .title("Bem vindo ao Achados e Perdidos UnB")
                .text("Esse aplicativo veio para facilitar a interação das pessoas que perdem com as que encontram objetos perdidos pelo campus.")
                .build());

        addIntroItem(new VerticalIntroItem.Builder()
                .backgroundColor(R.color.green)
                .image(R.drawable.lost)
                .title("Se encontrou algo...")
                .text("Você pode cadastrar esse objeto em uma das nossas listas de objetos perdidos. Nela você irá fornecer informações do local, a data, e uma descrição do objeto encontrado")
                .build());

        addIntroItem(new VerticalIntroItem.Builder()
                .backgroundColor(R.color.amber)
                .image(R.drawable.perdeu)
                .title("Se perdeu algo...")
                .text("Temos as listas de objetos encontrados e deixados nos departamentos da UnB, você também pode fazer uma busca pelo título ou descrição.")
                .build());

        addIntroItem(new VerticalIntroItem.Builder()
                .backgroundColor(R.color.pink)
                .image(R.drawable.status)
                .title("Algo a mais")
                .text("Você também pode ver a lista de objetos encontrados por você, nela você poderá definir o status dos objetos como \"Devolvido\", \"Comigo\" ou \"No departamento\". ")
                .build());

        addIntroItem(new VerticalIntroItem.Builder()
                .backgroundColor(R.color.blue)
                .image(R.drawable.face)
                .title("Compartilhe!")
                .text("Se quiser, pode sempre compartilhar suas atividades nos grupos de redes sociais e marcar seus amigos para aumentar as chances de encontrar ou devolver os bens.")
                .build());

        setVibrateEnabled(true);
        setVibrateIntensity(20);

        setNextText("PRÓXIMO");
        setDoneText("FIM");
        setSkipText("PULAR");


    }

    @Override
    protected Integer setLastItemBottomViewColor() {
        return R.color.colorPrimary;
    }

    @Override
    protected void onSkipPressed(View view) {

    }

    @Override
    protected void onFragmentChanged(int position) {

    }

    @Override
    protected void onDonePressed() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
