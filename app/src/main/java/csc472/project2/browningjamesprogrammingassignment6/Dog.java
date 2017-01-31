package csc472.project2.browningjamesprogrammingassignment6;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Browning on 11/1/16.
 */

public class Dog implements Parcelable {

    enum Type {Herding, Hound, Sporting, NonSporting, Working, Terrier, Toy}

    private String breed;
    private Type type;
    private String shortDescription;
    private String longDescription;


    public Dog(String breed, Type type, String shortDescription, String longDescription) {
        this.breed = breed;
        this.type = type;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public String getBreed() {
        return breed;
    }

    public Type getType() {
        return type;
    }


    private Dog(Parcel in) {
        breed = in.readString();
        type = Type.values()[in.readInt()];
        shortDescription = in.readString();
        longDescription = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(breed);
        out.writeInt(type.ordinal());
        out.writeString(shortDescription);
        out.writeString(longDescription);
    }

    @Override
    public String toString() {
        return "Dog{" +
                "breed='" + breed + '\'' +
                ", type='" + type + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", longDescription='" + longDescription + '\'' +
                '}';
    }

    public static final Parcelable.Creator<Dog> CREATOR
            = new Parcelable.Creator<Dog>() {
        public Dog createFromParcel(Parcel in) {
            return new Dog(in);
        }

        public Dog[] newArray(int size) {
            return new Dog[size];
        }
    };

    public static int getIconResourceDetail(String breed) {
        switch (breed.toUpperCase()){
            case "GERMAN SHEPHERD DOG":
                return R.drawable.gsd;
            case "AUSTRALIAN CATTLE DOG":
                return R.drawable.acd;
            case "BEAGLE":
                return R.drawable.beagle;
            case "GREYHOUND":
                return R.drawable.greyhound;
            case "NORWEGIAN LUNDEHUND":
                return R.drawable.nlh;
            case "POODLE":
                return R.drawable.poodle;
            case "BRITTANY":
                return R.drawable.brittany;
            case "BERNESE MOUNTAIN DOG":
                return R.drawable.bernese;
            case "LABRADOR RETRIEVER":
                return R.drawable.lab;
            case "STAFFORDSHIRE BULL TERRIER":
                return R.drawable.pit;
            case "ITALIAN GREYHOUND":
                return R.drawable.igh;
            case "MANCHESTER TERRIER":
                return R.drawable.manter;
        }
        return -1;
    }

    public static int getIconResource(Type type) {
        switch (type){
            case Herding:
                return R.drawable.herding;
            case Hound:
                return R.drawable.hound;
            case NonSporting:
                return R.drawable.nonworking;
            case Sporting:
                return R.drawable.sporting;
            case Terrier:
                return R.drawable.terrier;
            case Toy:
                return R.drawable.toy;
            case Working:
                return R.drawable.working;
        }
        return -1;
    }



}
