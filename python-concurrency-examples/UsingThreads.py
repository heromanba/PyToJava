
import threading
from threading import Thread
import time


if __name__ == "__main__":
    # Creating a thread that do nothing.
    created = Thread()
    created.start()
    # .run() runs on main thread

    # Assigning a task for running on a thread - we pass a Runnable instance
    threadWithTask = Thread(target=lambda : print(f"Inside thread {threading.current_thread().getName()}"))
    threadWithTask.start()

    class ThreadWithRunnable(Thread):
        def __init__(self, *args, **kwargs):
            super().__init__(*args, **kwargs)
            self.isInterrupted = False

        def run(self):
            while not threading.current_thread().isInterrupted:
                print(f"I'm not interrupted{threading.current_thread().getName()}")
        
        def interrupt(self):
            self.isInterrupted = True

    interruptable = ThreadWithRunnable()
    interruptable.start()
    time.sleep(5)
    interruptable.interrupt()