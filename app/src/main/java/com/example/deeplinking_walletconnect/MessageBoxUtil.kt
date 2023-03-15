package com.example.deeplinking_walletconnect

import android.content.DialogInterface
import android.app.AlertDialog
import android.util.Log

//Work in progress - cannot display ui elements from background threads like the ones in the callbacks
class MessageBoxUtil {
    companion object {
        fun showMessageBox(activityContext: FirstFragment, title: String, message: String) {
            // build alert dialog
            val dialogBuilder = AlertDialog.Builder(activityContext.activity)

            Log.e("HERE", "In message box util")

            // set message of alert dialog
            dialogBuilder.setMessage(message)
                // if the dialog is cancelable
                .setCancelable(false)
                // positive button text and action
                /*.setPositiveButton("Proceed", DialogInterface.OnClickListener {
                        dialog, id -> finish()
                })*/
                // negative button text and action
                .setNegativeButton("Ok", DialogInterface.OnClickListener {
                        dialog, id -> dialog.cancel()
                })

            // create dialog box
            val alert = dialogBuilder.create()
            // set title for alert dialog box
            alert.setTitle(title)
            // show alert dialog
            alert.show()
            Log.e("ALERT SHOW DONE", "")

        }
    }
}