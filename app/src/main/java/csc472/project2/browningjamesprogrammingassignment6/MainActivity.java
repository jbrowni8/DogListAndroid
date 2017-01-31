package csc472.project2.browningjamesprogrammingassignment6;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends ListActivity {

    private static final String TAG = "MainActivity";
    private static final int CODE = 100;
    private Dog selectedDog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new DogAdapter(this));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Log.d(TAG, "onListItemClick position=" + position + " id=" + id + " "
                + DOGS[position].getBreed());
        selectedDog = DOGS[position];
        Intent intent = new Intent(MainActivity.this, DogActivity.class);
        intent.putExtra("Dog", selectedDog);
        startActivityForResult(intent, CODE);
    }

    // More efficient version of adapter
    static class DogAdapter extends BaseAdapter {

        private LayoutInflater inflater;
        private Map<Dog.Type, Bitmap> icons;

        DogAdapter(Context context) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            icons = new HashMap<Dog.Type, Bitmap>();
            for (Dog.Type type : Dog.Type.values()) {
                icons.put(type, BitmapFactory.decodeResource(context.getResources(),
                        Dog.getIconResource(type)));
            }
        }

        @Override
        public int getCount() {
            return DOGS.length;
        }

        @Override
        public Object getItem(int i) {
            return DOGS[i];
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            View row = convertView;
            if (row == null) {
                row = inflater.inflate(R.layout.activity_main, parent, false);
                holder = new ViewHolder();
                holder.icon = (ImageView) row.findViewById(R.id.image);
                holder.name = (TextView) row.findViewById(R.id.text1);
                holder.description = (TextView) row.findViewById(R.id.text2);
                holder.rating = (TextView) row.findViewById(R.id.text3);
                row.setTag(holder);
            } else {
                holder = (ViewHolder) row.getTag();
            }

            Dog dog = DOGS[position];
            holder.name.setText(dog.getBreed());
            holder.description.setText(dog.getShortDescription());
            holder.icon.setImageBitmap(icons.get(dog.getType()));
            return row;
        }

        static class ViewHolder {
            TextView name;
            TextView description;
            TextView rating;
            ImageView icon;
        }
    }


    private static final Dog[] DOGS = {
            new Dog("GERMAN SHEPHERD DOG",
                    Dog.Type.Herding,
                    "Smart, confident, courageous, and steady; a true dog lover's dog.",
                    "The first impression of a good German Shepherd Dog is that of a strong, " +
                            "agile, well muscled animal, alert and full of life. It is well " +
                            "balanced, with harmonious development of the forequarter and " +
                            "hindquarter. The dog is longer than tall, deep-bodied, and presents " +
                            "an outline of smooth curves rather than angles. It looks substantial " +
                            "and not spindly, giving the impression, both at rest and in motion, " +
                            "of muscular fitness and nimbleness without any look of clumsiness " +
                            "or soft living. The ideal dog is stamped with a look of quality " +
                            "and nobility - difficult to define, but unmistakable when present." +
                            " Secondary sex characteristics are strongly marked, and every " +
                            "animal gives a definite impression of masculinity or femininity, " +
                            "according to its sex."),
            new Dog("AUSTRALIAN CATTLE DOG",
                    Dog.Type.Herding,
                    "Alert, curious, and pleasant.",
                    "The general appearance is that of a strong compact, symmetrically built " +
                            "working dog, with the ability and willingness to carry out his " +
                            "allotted task however arduous. Its combination of substance, power, " +
                            "balance and hard muscular condition must convey the impression of " +
                            "great agility, strength and endurance. Any tendency to grossness " +
                            "or weediness is a serious fault."),
            new Dog("BEAGLE",
                    Dog.Type.Hound,
                    "Beagles are loving and lovable, happy, easygoing, and companionable.",
                    "A miniature Foxhound, solid and big for his inches, " +
                            "with the wear-and-tear look of the hound that can last in the " +
                            "chase and follow his quarry to the death."),

            new Dog("GREYHOUND",
                    Dog.Type.Hound,
                    "Independent, gentle, noble, and oh so sweet, but intense when on the run.",
                    "Long and narrow, fairly wide between the ears, " +
                            "scarcely perceptible stop, little or no development of nasal sinuses, " +
                            "good length of muzzle, which should be powerful without coarseness. " +
                            "Teeth very strong and even in front. Ears are mall " +
                            "and fine in texture, thrown back and folded, except when excited, " +
                            "when they are semi-pricked. Eyes are dark, bright, " +
                            "intelligent, indicating spirit."),
            new Dog("NORWEGIAN LUNDEHUND",
                    Dog.Type.NonSporting,
                    "Loving and loyal, also brave, tenacious, and a bit stubborn.",
                    "The Norwegian Lundehund is a small rectangular and agile Spitz breed with " +
                            "unique characteristics not found in any other breed. Originating on " +
                            "remote islands of arctic Norway, the dog was used to wrestle and " +
                            "retrieve live puffin birds from the crevices of steep vertical " +
                            "cliffs. To enable the dog to climb, descend, and brake on these " +
                            "cliffs, unique structural characteristics have evolved and must " +
                            "be present as they define this breed: a minimum of six toes on " +
                            "each foot and elongated rear foot pads; an elastic neck that " +
                            "allows the head to bend backward to touch the spine, letting the " +
                            "dog turn around in narrow puffin bird caves; and shoulders " +
                            "flexible enough to allow the front legs to extend flat to " +
                            "the side in order to hug the cliffs. This shoulder structure " +
                            "produces a peculiar rotary movement. Finally, the ears " +
                            "close and fold forward or backward to protect from debris. " +
                            "The temperament is alert but not expected to be " +
                            "outgoing toward strangers."),
            new Dog("POODLE",
                    Dog.Type.NonSporting,
                    "Proud, active and very smart.",
                    "That of a very active, intelligent and elegant-appearing dog, squarely " +
                            "built, well proportioned, moving soundly and carrying " +
                            "himself proudly. Properly clipped in the traditional fashion " +
                            "and carefully groomed, the Poodle has about him an air " +
                            "of distinction and dignity peculiar to himself."),
            new Dog("BRITTANY",
                    Dog.Type.Sporting,
                    "Bright, upbeat, fun-loving at home; a tireless, enthusiastic worker afield.",
                    "A compact, closely knit dog of medium size, " +
                            "a leggy dog having the appearance, as well as the agility, " +
                            "of a great ground coverer. Strong, vigorous, energetic and quick " +
                            "of movement. Ruggedness, without clumsiness, is a characteristic " +
                            "of the breed. He can be tailless or has a tail docked " +
                            "to approximately four inches. "),
            new Dog("Labrador Retriever".toUpperCase(),
                    Dog.Type.Sporting,
                    "Friendly and outgoing, Labs play well with others.",
                    "The Labrador Retriever is a strongly built, medium-sized, short-coupled, " +
                            "dog possessing a sound, athletic, well-balanced conformation that " +
                            "enables it to function as a retrieving gun dog; the substance and " +
                            "soundness to hunt waterfowl or upland game for long hours under " +
                            "difficult conditions; the character and quality to win in the " +
                            "show ring; and the temperament to be a family companion. " +
                            "Physical features and mental characteristics should denote a " +
                            "dog bred to perform as an efficient Retriever of game with a stable " +
                            "temperament suitable for a variety of pursuits beyond the hunting environment.\n" +
                            "The most distinguishing characteristics of the Labrador " +
                            "Retriever are its short, dense, weather resistant coat; an \"otter\" " +
                            "tail; a clean-cut head with broad back skull and moderate stop; " +
                            "powerful jaws; and its \"kind,\" friendly eyes, expressing character, " +
                            "intelligence and good temperament."),
            new Dog("Staffordshire Bull Terrier".toUpperCase(),
                    Dog.Type.Terrier,
                    "Brave, tenacious, a bit stubborn; but also gentle, playful, and clever.",
                    "The Staffordshire Bull Terrier is a smooth-coated dog. It should be of great " +
                            "strength for its size and, although muscular, should be active and agile."),
            new Dog("Italian Greyhound".toUpperCase(),
                    Dog.Type.Toy,
                    "Sensitive and alert, playful, highly affectionate.",
                    "The Italian Greyhound is very similar to the Greyhound, but much smaller " +
                            "and more slender in all proportions and of ideal elegance and grace."),
            new Dog("Manchester Terrier".toUpperCase(),
                    Dog.Type.Toy,
                    "Spirited, bright, keenly observant; dead loyal, in an independent terrier way.",
                    "Manchester Terriers combine the streamlined grace of a " +
                            "small coursing hound and the instincts of a fearless rat terrier. " +
                            "These racy little dogs come in two size varieties: " +
                            "Toy (not exceeding 12 pounds) and Standard (not exceeding 22 pounds). " +
                            "They're easily recognized by a tight coat of rich mahogany " +
                            "tan and jet black. The head is long and wedge-shaped; " +
                            "tan spots above each eye point up a watchful expression. " +
                            "Manchesters can motor, running with good reach in front " +
                            "and propulsive rear drive powered by a muscular caboose."),
            new Dog("Bernese Mountain Dog".toUpperCase(),
                    Dog.Type.Working,
                    "Good-natured and calm.",
                    "The Bernese Mountain Dog is a striking. tri-colored, large dog. " +
                            "He is sturdy and balanced. He is intelligent, strong and agile enough " +
                            "to do the draft and droving work for which he was used in the " +
                            "mountainous regions of his origin. Male dogs appear masculine, " +
                            "while bitches are distinctly feminine.")
    };
}
