package com.dhamo.dsa;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Objects.hash;

public class CustomHashMap {

    CustomEntrySet []entrySet;
    int size;
    CustomHashMap(int size){
        this.size = size;
        entrySet = new CustomEntrySet[size];
    }

    public void put(int key, int value){
        int hash = hash(key);
        CustomEntrySet entrySet = this.entrySet[hash];
        if(entrySet == null){
            this.entrySet[hash] = new CustomEntrySet(key,value);
        }else{
            CustomEntrySet currentEntrySet = entrySet;
            while(currentEntrySet.next != null){
                if(currentEntrySet.key == key){
                    currentEntrySet.value = value;
                    return;
                }
                currentEntrySet = currentEntrySet.next;
            }
            if(currentEntrySet.key == key){
                currentEntrySet.value = value;
            }else{
                currentEntrySet.next = new CustomEntrySet(key,value);
            }
        }
    }

    public int get(int key){
        int hash = hash(key);
        CustomEntrySet entrySet = this.entrySet[hash];
        if(entrySet == null){
            return -1;
        }else{
            CustomEntrySet currentEntrySet = entrySet;
            while(currentEntrySet != null){
                if(currentEntrySet.key == key){
                    return currentEntrySet.value;
                }
                currentEntrySet = currentEntrySet.next;
            }
            return -1;
        }
    }

    public  Set<Integer> customEntryset(){
        return Arrays.stream(entrySet).map(e -> e.key).collect(Collectors.toSet());
    }

    public List<Integer> getKeys(){
        return Arrays.stream(entrySet).map(e -> e.key).collect(Collectors.toList());
    }

    public List<Integer> getValues(){
        return Arrays.stream(entrySet).map(e -> e.value).collect(Collectors.toList());
    }

   class CustomEntrySet{
        int key;
        int value;
        CustomEntrySet next;
        CustomEntrySet(int key, int value){
            this.key = key;
            this.value = value;
        }

    }
}
