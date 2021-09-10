package src;

class DisplayRandom extends DisplayRandomBase {

    public DisplayRandom(String[] csvLines) {
        super(csvLines);
    }

    // @Override
    public void sort(Plane[] data, int low, int hight) {
        int i = low;
        int j = hight;
        Plane index = data[i];
        if(low >= hight){
            return;
        }
        while(i<j){
            while (i < j && data[j].compareTo(index) >= 0) 
                j--;
            if (i < j) 
                data[i++] = data[j];
            while(i < j && data[j].compareTo(index) < 0)
                i++;
            if(i < j)
                data[j--] = data[i];
            
        }
        data[i] = index;
        sort(data, low, i - 1);
        sort(data, i + 1, hight);

    }

    public void quickSort(Plane[] data){
        sort(data,0,data.length - 1);
    }







    /* Implement all the necessary methods here */
}

class DisplayPartiallySorted extends DisplayPartiallySortedBase {

    public DisplayPartiallySorted(String[] scheduleLines, String[] extraLines) {
        super(scheduleLines, extraLines);
    }

    @Override
    Plane[] sort() {
        
    }
    
    Plane[] insertSort(Plane[] schedule, Plane[] extraPlanes){
        for(int i = 0; i < extraPlanes.length; i++) {
            Plane temp = extraPlanes[i];
            int j = schedule.length;
            while(j > 0 && temp.compareTo(schedule[j-1]) < 0){
                schedule[j] = schedule[j - 1];
                j--;
            }
            schedule[j] = temp;
        }
        return schedule;
    }
    /* Implement all the necessary methods here */
}
