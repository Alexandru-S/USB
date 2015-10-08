//import android.app.Activity;

/*import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by lebuckle on 21/11/14.
 */
//public class Min3dTest {
//}*/
package com.example.lebuckle.blender_practice;
        import android.os.Bundle;
        import android.app.Activity;
        import android.content.Intent;
public class Min3dTest extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.startActivity( new Intent(this,Obj3DView.class));
    }
}