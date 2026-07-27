import java.util.concurrent.locks.ReentrantLock;

class DiningPhilosophers {
    private ReentrantLock[] forks;

    public DiningPhilosophers() {
        forks = new ReentrantLock[5];
        for (int i = 0; i < 5; i++) {
            forks[i] = new ReentrantLock();
        }
    }

    // philosopher: 0 to 4
    // pickLeftFork, pickRightFork, eat, putLeftFork, putRightFork are provided actions
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {

        int leftFork = philosopher;
        int rightFork = (philosopher + 1) % 5;

        // To avoid deadlock, always lock the lower-numbered fork first
        ReentrantLock firstFork = forks[Math.min(leftFork, rightFork)];
        ReentrantLock secondFork = forks[Math.max(leftFork, rightFork)];

        firstFork.lock();
        secondFork.lock();

        // Perform actions
        if (leftFork < rightFork) {
            pickLeftFork.run();
            pickRightFork.run();
        } else {
            pickRightFork.run();
            pickLeftFork.run();
        }

        eat.run();

        putLeftFork.run();
        putRightFork.run();

        // Release locks
        secondFork.unlock();
        firstFork.unlock();
    }
}
