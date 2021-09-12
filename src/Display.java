package src;

class DisplayRandom extends DisplayRandomBase {

    public DisplayRandom(String[] csvLines) {
        super(csvLines);
    }

    @Override
    public Plane[] sort() {
        quickSort(getData(), 0, getData().length - 1);
        return getData();
    }

    public void quickSort(Plane[] data, int begin, int end) {
        if (begin >= end) {
            return;
        }
        int p1 = begin;
        int p2 = end;
        Plane index = data[p1];
        boolean dr = true;

        L1:
        while (p1 < p2) {
            if (dr) {
                for (int i = p2; i > p1; i--) {
                    if (data[i].compareTo(index) <= 0) {
                        data[p1++] = data[i];
                        p2 = i;
                        dr = !dr;
                        continue L1;
                    }
                }
                p2 = p1;
            } else {
                for (int i = p1; i < p2; i++) {
                    if (data[i].compareTo(index) >= 0) {
                        data[p2--] = data[i];
                        p1 = i;
                        dr = !dr;
                        continue L1;
                    }
                }
                p1 = p2;
            }
        }
        data[p1] = index;
        quickSort(data, begin, p1 - 1);
        quickSort(data, p1 + 1, end);

    }







    /* Implement all the necessary methods here */
}

class DisplayPartiallySorted extends DisplayPartiallySortedBase {

    public DisplayPartiallySorted(String[] scheduleLines, String[] extraLines) {
        super(scheduleLines, extraLines);
    }

    @Override
    Plane[] sort() {
        return insertSort(getSchedule(), getExtraPlanes());
    }

    /* Implement all the necessary methods here */
    Plane[] insertSort(Plane[] schedule, Plane[] extraPlanes) {
        Plane[] newSchedule = new Plane[schedule.length + extraPlanes.length];
        for (int k = 0; k < schedule.length; k++) {
            newSchedule[k] = schedule[k];
        }
        for (int i = 0; i < extraPlanes.length; i++) {
            Plane temp = extraPlanes[i];
            int j = schedule.length + i;
            while (j > 0 && temp.compareTo(newSchedule[j - 1]) < 0) {
                newSchedule[j] = newSchedule[j - 1];
                j--;
            }
            newSchedule[j] = temp;
        }
        return newSchedule;
    }

}
