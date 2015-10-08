package com.example.lebuckle.blender_practice;


        import min3d.Shared;
        import min3d.Utils;
        import min3d.core.Object3dContainer;
        import min3d.core.RendererActivity;
        import min3d.objectPrimitives.Box;
        import min3d.objectPrimitives.Sphere;
        import min3d.objectPrimitives.Rectangle;
        import min3d.parser.IParser;
        import min3d.parser.Parser;
        import min3d.vos.Color4;
        import min3d.vos.Light;
        import android.graphics.Bitmap;

public class ExampleFog extends RendererActivity {
    private Box[] boxes;
    private Object3dContainer[] objects;
    private Sphere[] spheres;


    @Override
    public void initScene() {
        Light light = new Light();
        scene.lights().add(light);
        scene.camera().position.x = 0;
        scene.camera().position.y = 0;
        scene.camera().position.z = 10;

        Bitmap b = Utils.makeBitmapFromResourceId(R.drawable.barong);
        Shared.textureManager().addTextureId(b, "poipoi", false);
        b.recycle();


        b = Utils.makeBitmapFromResourceId(R.drawable.poipoi);
        Shared.textureManager().addTextureId(b, "wood", false);
        b.recycle();


        IParser parser = Parser.createParser(Parser.Type.OBJ,
                getResources(), "com.example.lebuckle.blender_practice:raw/snowman2_obj", true);
        parser.parse();



        boxes = new Box[5];
        spheres = new Sphere[5];
        objects  = new Object3dContainer[5];

        for(int i=0; i<5; i++)
        {
           // object[i].scale().x = object[i].scale().y = object[i].scale().z = .3f;

            Sphere sphere = new Sphere(0.2f, 10, 8,  true,true,false);
            Box box = new Box(1, 1, 1);
            //objects[i] = parser.getParsedObject();
            Object3dContainer obj = new Object3dContainer();

            box.position().x = (float) (-4 + ( Math.random() * 8));
            sphere.position().x = (float) (-4 + ( Math.random() * 8));
            obj.position().x = (float) (-4 + ( Math.random() * 8));

            box.position().y = (float) (-4 + ( Math.random() * 8));
            sphere.position().y = (float) (-4 + ( Math.random() * 8));
            obj.position().y = (float) (-4 + ( Math.random() * 8));

            box.position().z = (i + 1) * -8;
            sphere.position().z = (i + 1) * -8;
            obj.position().z = (i + 1) * -8;

            box.textures().addById("poipoi");
            sphere.textures().addById("poipoi");

            box.vertexColorsEnabled(false); ///box.vert
            sphere.vertexColorsEnabled(false);
            obj.vertexColorsEnabled(false);

            boxes[i] = box;
            spheres[i] = sphere;
            objects[i] = obj;

            scene.addChild(boxes[i]);
            scene.addChild(spheres[i]);
            scene.addChild(objects[i]);

        }

        Color4 planeColor = new Color4(255, 255, 255, 255);
        Rectangle east = new Rectangle(40, 12, 2, 2, planeColor);
        Rectangle west = new Rectangle(40, 12, 2, 2, planeColor);
        Rectangle up = new Rectangle(40, 12, 2, 2, planeColor);
        Rectangle down = new Rectangle(40, 12, 2, 2, planeColor);

        east.position().x = -6;
        east.rotation().y = -90;
        east.position().z = -20;
        east.lightingEnabled(false);
        east.textures().addById("wood");

        west.position().x = 6;
        west.rotation().y = 90;
        west.position().z = -20;
        west.lightingEnabled(false);
        west.textures().addById("wood");

        up.rotation().x = -90;
        up.rotation().z = 90;
        up.position().y = 6;
        up.position().z = -20;
        up.lightingEnabled(false);
        up.textures().addById("wood");

        down.rotation().x = 90;
        down.rotation().z = 90;
        down.position().y = -6;
        down.position().z = -20;
        down.lightingEnabled(false);
        down.textures().addById("wood");

        scene.addChild(east);
        scene.addChild(west);
        scene.addChild(up);
        scene.addChild(down);

        scene.fogColor(new Color4(0, 0, 0, 255) );
        scene.fogNear(10);
        scene.fogFar(40);
        scene.fogEnabled(true);
    }

    @Override
    public void updateScene()
    {
        for(int i=0; i<5; i++)
        {
            Box box = boxes[i];
            Sphere sphere = spheres[i];
            Object3dContainer obj = objects[i];

            box.position().z += .25;
            sphere.position().z += .25;
            obj.position().z += .25;

            box.rotation().x++;
            sphere.rotation().x++;
            obj.rotation().x++;

            box.rotation().y++;
            sphere.rotation().y++;
            obj.rotation().y++;

            if( box.position().z > scene.camera().position.z)
                box.position().z = -40;

            if( sphere.position().z > scene.camera().position.z)
                sphere.position().z = -40;

            if( obj.position().z > scene.camera().position.z)
                obj.position().z = -40;
        }
    }
}