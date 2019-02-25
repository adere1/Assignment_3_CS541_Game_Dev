package com.my.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.actions.ParallelAction;
import com.badlogic.gdx.scenes.scene2d.actions.RepeatAction;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import sun.rmi.runtime.Log;


public class MyGame extends ApplicationAdapter {
	private Stage stage;

    private int Count = 0;

	int X_left= 150;
	int X_right = 150;
	int Y_top = 1200;
	int Y_bottom = -120;

	float [] x1 = new float[20];

	/*Image image1 ;
	Image image2 ;
	Image image3 ;
	Image image4 ;
	Image image5 ;
	Image image6 ;
	final Image image7 = null;
	final Image image8 = null;
     */

	private Texture texture12;
	private Texture texture ;
	private Texture texture1;
	private Texture texture2;
	private Texture texture3;
	private Texture texture4;
	private Texture texture5;
	private Texture texture6;

	private Image image8;
	private Image image1;
	private Image image2;
	private Image image3;
	private Image image4;
	private Image image5;
	private Image image6;
	private Image image7;

	@Override
	public void create () {
		stage = new Stage(new ScreenViewport());
		Gdx.input.setInputProcessor(stage);

		texture = new Texture("car12.png");
		texture1 = new Texture("car2.png");
		texture2 = new Texture("car13.png");
		texture3 = new Texture("car3.png");
		texture4 = new Texture("car4.png");
		texture5 = new Texture("car5.png");
		texture6 = new Texture("car6.png");
		Texture texture7 = new Texture("car7.png");
		Texture texture8 = new Texture("car8.png");
		Texture texture9 = new Texture("car9.png");
		Texture texture10 = new Texture("car10.png");
		Texture texture11 = new Texture("car11.png");
		texture12 = new Texture("antman.png");


		image1 = new Image(texture);
		image2 = new Image(texture1);
		image3 = new Image(texture2);
		image4 = new Image(texture3);
		image5 = new Image(texture4);
		image6 = new Image(texture5);
		image7 = new Image(texture6);
		image8 = new Image(texture12);

		image1.setPosition(X_left,Y_top);
		image1.rotateBy(90);

		image2.setPosition(X_left+150,Y_top);
		image2.rotateBy(90);

		image3.setPosition(X_left+300,Y_bottom);
		image3.rotateBy(90);

		image4.setPosition(X_left+450,Y_bottom);
		image4.rotateBy(90);

		image5.setPosition(X_left+600,Y_bottom);
		image5.rotateBy(90);

		image6.setPosition(X_left+750,Y_bottom);
		image6.rotateBy(90);

		image7.setPosition(X_left+900,Y_bottom);
		image7.rotateBy(90);

		image8.setPosition(X_left+1200,500);
		image8.rotateBy(90);


		/*for(int i = 1;i<13;i++){
			Texture texture = new Texture("car12.png");
		}*/






		//image1.setOrigin(image1.getWidth()/2,image1.getHeight()/2);
		stage.addActor(image1);
		stage.addActor(image2);
		stage.addActor(image3);
		stage.addActor(image4);
		stage.addActor(image5);
		stage.addActor(image6);
		stage.addActor(image7);
		stage.addActor(image8);

		Skin skin1 = new Skin(Gdx.files.internal("skin/glassy-ui.json"));

		TextButton up = new TextButton("<",skin1);
		up.setSize(100,100);
		up.setPosition(1400,500);

		up.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				//if(Count == 0) {
					Count = 1;
					System.out.println("Inside");
					x = image8.getX();
					y = image8.getY();

				    if(image8.getX()%150 == 0) {
						MoveToAction moveaction6 = new MoveToAction();
						moveaction6.setPosition(x - 150, y);
						moveaction6.setDuration(5);
						image8.addAction(moveaction6);
					}


				//}
				//image8.setPosition(x-150,y);
				//System.out.println("-------X:-----"+x);
				/*if(x == 1200){
					while(x == 1200){
						float x1 = image7.getX();
						float y1 = image7.getY();

						if(y1+64 > y && y1-64 < y ){
							System.out.println("------------collision----------------");
						}
					}
				}*/

				return super.touchDown(event, x, y, pointer, button);
			}
		});

		//Skin skin1 = new Skin(Gdx.files.internal("skin/glassy-ui.json"));

		TextButton down = new TextButton(">",skin1);
		down.setSize(100,100);
		down.setPosition(1520,500);

		down.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				System.out.println("Inside");
				x = image8.getX();
				y = image8.getY();
				//image8.scaleBy(2);
				if(x+150 <= 1350)
				image8.setPosition(x+150,y);
				//image8.scaleBy(1);
				return super.touchDown(event, x, y, pointer, button);
			}
		});

		TextButton left = new TextButton("left",skin1);
		left.setSize(100,100);
		left.setPosition(1455,400);

		left.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				System.out.println("Inside");
				x = image8.getX();
				y = image8.getY();
				if((y-20 >= 64))
				image8.setPosition(x,y-20);
				return super.touchDown(event, x, y, pointer, button);
			}
		});

		TextButton right = new TextButton("right",skin1);
		right.setSize(100,100);
		right.setPosition(1455,600);

		right.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				System.out.println("Inside");
				x = image8.getX();
				y = image8.getY();
				if(y+20 < 1100)
				image8.setPosition(x,y+20);
				return super.touchDown(event, x, y, pointer, button);
			}
		});

		stage.addActor(down);
		stage.addActor(up);
		stage.addActor(left);
		stage.addActor(right);



		ParallelAction backaction = new ParallelAction();
		backaction.addAction(Actions.moveTo(X_right,Y_top,0,Interpolation.exp5Out));

		ParallelAction backaction1 = new ParallelAction();
		backaction1.addAction(Actions.moveTo(X_right+150,Y_top,0,Interpolation.exp5Out));

		ParallelAction backaction2 = new ParallelAction();
		backaction2.addAction(Actions.moveTo(X_right+300,Y_bottom,0,Interpolation.exp5Out));

		ParallelAction backaction3 = new ParallelAction();
		backaction3.addAction(Actions.moveTo(X_right+450,Y_bottom,0,Interpolation.exp5Out));

		ParallelAction backaction4 = new ParallelAction();
		backaction4.addAction(Actions.moveTo(X_right+600,Y_bottom,0,Interpolation.exp5Out));

		ParallelAction backaction5 = new ParallelAction();
		backaction5.addAction(Actions.moveTo(X_right+750,Y_bottom,0,Interpolation.exp5Out));

		ParallelAction backaction6 = new ParallelAction();
		backaction6.addAction(Actions.moveTo(X_right+900,Y_bottom,0,Interpolation.exp5Out));

		//backaction.addAction(Actions.scaleTo(1,1,1,Interpolation.exp5Out));

		MoveToAction moveaction = new MoveToAction();
		moveaction.setPosition(X_right,Y_bottom);
		moveaction.setDuration(8);
		moveaction.setInterpolation(Interpolation.smooth);

		MoveToAction moveaction1 = new MoveToAction();
		moveaction1.setPosition(X_right+150,Y_bottom);
		moveaction1.setDuration(10);
		moveaction1.setInterpolation(Interpolation.smooth);

		MoveToAction moveaction2 = new MoveToAction();
		moveaction2.setPosition(X_right+300,Y_top);
		moveaction2.setDuration(8);
		moveaction2.setInterpolation(Interpolation.smooth);


		MoveToAction moveaction3 = new MoveToAction();
		moveaction3.setPosition(X_right+450,Y_top);
		moveaction3.setDuration(14);
		moveaction3.setInterpolation(Interpolation.smooth);

		MoveToAction moveaction4 = new MoveToAction();
		moveaction4.setPosition(X_right+600,Y_top);
		moveaction4.setDuration(12);
		moveaction4.setInterpolation(Interpolation.smooth);

		MoveToAction moveaction5 = new MoveToAction();
		moveaction5.setPosition(X_right+750,Y_top);
		moveaction5.setDuration(6);
		moveaction5.setInterpolation(Interpolation.smooth);

		MoveToAction moveaction6 = new MoveToAction();
		moveaction6.setPosition(X_right+900,Y_top);
		moveaction6.setDuration(8);
		moveaction6.setInterpolation(Interpolation.smooth);


		SequenceAction sequence = new SequenceAction();
		sequence.addAction(moveaction);
		sequence.addAction(backaction);

		SequenceAction sequence1 = new SequenceAction();
		sequence1.addAction(moveaction1);
		sequence1.addAction(backaction1);

		SequenceAction sequence2 = new SequenceAction();
		sequence2.addAction(moveaction2);
		sequence2.addAction(backaction2);


		SequenceAction sequence3 = new SequenceAction();
		sequence3.addAction(moveaction3);
		sequence3.addAction(backaction3);


		SequenceAction sequence4 = new SequenceAction();
		sequence4.addAction(moveaction4);
		sequence4.addAction(backaction4);



		SequenceAction sequence5 = new SequenceAction();
		sequence5.addAction(moveaction5);
		sequence5.addAction(backaction5);


		SequenceAction sequence6 = new SequenceAction();
		sequence6.addAction(moveaction6);
		sequence6.addAction(backaction6);


		RepeatAction infiniteLoop = new RepeatAction();
		infiniteLoop.setCount(RepeatAction.FOREVER);
		infiniteLoop.setAction(sequence);

		RepeatAction infiniteLoop1 = new RepeatAction();
		infiniteLoop1.setCount(RepeatAction.FOREVER);
		infiniteLoop1.setAction(sequence1);

		RepeatAction infiniteLoop2 = new RepeatAction();
		infiniteLoop2.setCount(RepeatAction.FOREVER);
		infiniteLoop2.setAction(sequence2);

		RepeatAction infiniteLoop3 = new RepeatAction();
		infiniteLoop3.setCount(RepeatAction.FOREVER);
		infiniteLoop3.setAction(sequence3);

		RepeatAction infiniteLoop4 = new RepeatAction();
		infiniteLoop4.setCount(RepeatAction.FOREVER);
		infiniteLoop4.setAction(sequence4);

		RepeatAction infiniteLoop5 = new RepeatAction();
		infiniteLoop5.setCount(RepeatAction.FOREVER);
		infiniteLoop5.setAction(sequence5);

		RepeatAction infiniteLoop6 = new RepeatAction();
		infiniteLoop6.setCount(RepeatAction.FOREVER);
		infiniteLoop6.setAction(sequence6);



		image1.addAction(infiniteLoop);
        image2.addAction(infiniteLoop1);
		image3.addAction(infiniteLoop2);
		image4.addAction(infiniteLoop3);
		image5.addAction(infiniteLoop4);
		image6.addAction(infiniteLoop5);
		image7.addAction(infiniteLoop6);

        /*while(true){

			float x1 = image8.getX();
			float y1 = image8.getY();

        	float x = image7.getX();
        	float y = image7.getY();


        	if( (x1+64 > x - 64) | (y1+64 > y - 64) | (x1-64 > x + 64) | (y1-64 > y + 64)  ){
        		System.out.println("----------------Collision---------------");
			}

		}*/
	}





	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);



		stage.act();
		stage.draw();
		/*if(image8.getX() == 1200){
                if(image7.getY()+64 > image8.getY() | image7.getY()-64 < image8.getY()){
                	System.out.println("**********---Collisoin-");
				}
		}*/
		float x = image8.getX();
		float y = image8.getY();

        if((x < (1050+64)) && (x >=(1050-64))){
			float y1 = image7.getY();
			float x1 = image7.getX();
			if(y1+128>y && y1-128 < y){
                System.out.println("----X-------------"+x);
                image8.clearActions();
				image8.setPosition(1350,500);
			}
        }

        if((x < (900+64)) && (x >=(900-64))){
            float y1 = image6.getY();
            if(y1+64>y && y1-64 < y){
				image8.clearActions();
                image8.setPosition(1350,500);
            }
        }

        if((x < (750+64)) && (x >=(750-64))){
            float y1 = image5.getY();
            if(y1+64>y && y1-64 < y){
				image8.clearActions();
                image8.setPosition(1350,500);
            }
        }

        if((x < (600+64)) && (x >=(600-64))){
            float y1 = image4.getY();
            if(y1+64>y && y1-64 < y){
				image8.clearActions();
                image8.setPosition(1350,500);
            }
        }

        if((x < (450+64)) && (x >=(450-64))){
            float y1 = image3.getY();
            if(y1+64>y && y1-64 < y){
				image8.clearActions();
                image8.setPosition(1350,500);
            }
        }

        if((x < (300+64)) && (x >=(300-64))){
            float y1 = image2.getY();
            if(y1+64>y && y1-64 < y){
				image8.clearActions();
                image8.setPosition(1350,500);
            }
        }

        if((x < (150+64)) && (x >=(150-64))){
            float y1 = image1.getY();
            if(y1+64>y && y1-64 < y){
				image8.clearActions();
                image8.setPosition(1350,500);
            }
        }


	}
	

}
