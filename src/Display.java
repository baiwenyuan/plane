package src;

class DisplayRandom extends DisplayRandomBase {

    public DisplayRandom(String[] csvLines) {
        super(csvLines);
    }

    @Override
    public Plane[] sort() {
        quickSort(getData(),0,getData().length - 1);
        return getData();
    }

    public void quickSort(Plane[] data,int low, int hight){
        
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
        quickSort(data, low, i - 1);
        quickSort(data, i + 1, hight);

    }







    /* Implement all the necessary methods here */
}

class DisplayPartiallySorted extends DisplayPartiallySortedBase {

    public DisplayPartiallySorted(String[] scheduleLines, String[] extraLines) {
        super(scheduleLines, extraLines);
    }

    @Override
    Plane[] sort() {
        insertSort(getSchedule(), getExtraPlanes());
        return getSchedule();
    }
   /* Implement all the necessary methods here */ 
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

}
