package com.example.aroma.presenter;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.example.aroma.User;
import com.example.aroma.fragments.ArticleFragment;
import com.example.aroma.models.Article;
import com.example.aroma.models.Category;
import com.example.aroma.models.FarmerRegistrationForm;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class MainPresenter {

    IMainView view;
    Context context;
    private final FirebaseAuth auth;
    private final FirebaseFirestore db;
    private  final FirebaseDatabase rdb;

    public  MainPresenter(IMainView view)
    {
        auth=FirebaseAuth.getInstance();
        db= FirebaseFirestore.getInstance();
        rdb=FirebaseDatabase.getInstance();
        this.view=view;
    }

    public MainPresenter() {
        auth=FirebaseAuth.getInstance();
        db= FirebaseFirestore.getInstance();
        rdb=FirebaseDatabase.getInstance();
    }

    public  void signIn(String email, String password)
    {
        //authenticate user
        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener((Activity) context, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        // progressBar.setVisibility(View.GONE);
                        if (task.isSuccessful()) {
                            getUserInformation(auth.getCurrentUser().getEmail());

                        } else {
                            //Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            //startActivity(intent);
                            // finish();
                            view.onError("Failed to login: "+task.getException().getMessage());
                        }
                    }
                });

    }

    private  void getUserInformation(String email)
    {
        email=email.toLowerCase();
        db.collection("users").whereEqualTo("email",email).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.getResult().size()>0)
                {
                    User user=task.getResult().getDocuments().get(0).toObject(User.class);
                    view.onLoginSuccesful();
                    return;
                }

                view.onError("Something went wrong!");

            }
        });
    }


    //SIGN UP
    public void createUser(final User user, String password)
    {
        auth.createUserWithEmailAndPassword(user.getEmail(), password)
                .addOnCompleteListener((Activity) context, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        //checking if success
                        if(task.isSuccessful()){
                            //display some message here
                            addUser(user);

                            //  registerView;
                        }else{
                            //display some message here
                            view.onError("Failed to Register User: "+task.getException().getMessage());

                        }

                    }
                });


    }

    private   void addUser(User user){


        CollectionReference dbCourses = db.collection("users");

        dbCourses.add(user).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                // after the data addition is successful
                // we are displaying a success toast message.
                //Toast.makeText(MainActivity.this, "Your Course has been added to Firebase Firestore", Toast.LENGTH_SHORT).show();
                view.onSuccess();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                // this method is called when the data addition process is failed.
                // displaying a toast message when data addition is failed.
                // Toast.makeText(MainActivity.this, "Fail to add course \n" + e, Toast.LENGTH_SHORT).show();

                view.onError(e.getMessage());
            }
        });
    }


    public  void getCategories()
    {
        ArrayList<Category> list=new ArrayList<>();
      rdb.getReference().child("categories").addValueEventListener(new ValueEventListener() {
          @Override
          public void onDataChange(@NonNull DataSnapshot snapshot) {
              list.clear();
              for(DataSnapshot snapshot1:snapshot.getChildren())
              {
                  Category category= snapshot1.getValue(Category.class);
                  list.add(category);


              }

              view.onCategoriesRetrieved(list);

          }

          @Override
          public void onCancelled(@NonNull DatabaseError error) {
               view.onError(error.getMessage());
          }
      });
    }


    public  void getArticles(String cat, ArticleFragment view)
    {
        ArrayList<Article> list=new ArrayList<>();
        Query query =  rdb.getReference().child("articles").orderByChild("category").equalTo(cat);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(final DataSnapshot snapshot) {
                list.clear();
                for(DataSnapshot snapshot1:snapshot.getChildren())
                {
                    Article article= snapshot1.getValue(Article.class);
                    list.add(article);


                }
                view.onArticlesReceived(list);
            }

            @Override
            public void onCancelled(final DatabaseError databaseError) {
                view.onError(databaseError.getMessage());
            }
        });

    }


    public  void registerFarmer(FarmerRegistrationForm farmerRegistrationForm)
    {
        rdb.getReference().child("farmerforms").child(farmerRegistrationForm.getAadhadNo()).setValue(farmerRegistrationForm);
    }




}
