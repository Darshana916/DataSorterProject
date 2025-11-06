# DataSorterProject

**Course:** CIT300  
**Project type:** Group assignment (4 members)  
**Description:** Java console application that compares three sorting algorithms: Bubble Sort, Merge Sort, and Quick Sort. The program provides a menu to input numbers (manual or random), run each sort, and show a performance comparison (time in ms + step count).

## Files (one per team member)
- `BubbleSort.java`  — Member 1 (Bubble Sort implementation)
- `MergeSort.java`   — Member 2 (Merge Sort implementation)
- `QuickSort.java`   — Member 3 (Quick Sort implementation)
- `MainSorter.java`  — Member 4 (Menu + integration)

## How to compile & run (Windows)
1. Open Command Prompt or Terminal.
2. Move to the `src` folder:
3. Compile all Java files:
##javac *.java
4. Run the program:


java MainSorter

## Example usage
1. Choose `1` to enter numbers manually (e.g. `8 3 5 1 9`).
2. Choose `6` to compare all algorithms and see the results table.

## Team roles (example)
- Member 1: BubbleSort.java — explain bubble sort and run demo
- Member 2: MergeSort.java — explain merge sort and run demo
- Member 3: QuickSort.java — explain quick sort and run demo
- Member 4: MainSorter.java — run the program, show the menu & comparison table

## How to submit
- Push project to a public/private GitHub repo.
- Submit the GitHub URL and a short demo video showing the program running.

## Git / GitHub tips
- Create a branch per team member: `git checkout -b member1`
- Each member commits their file and opens a Pull Request (PR) to `main`.
- Merge PRs and resolve conflicts in GitHub UI or locally.

## Troubleshooting
- If `javac` is not recognized, install JDK and add it to PATH (install Temurin/Adoptium JDK 17 recommended).
- Ensure files are saved as `.java` (not `.txt`) and located in `src`.

## License & Acknowledgements
- (Optional) Add your group names and student IDs here.
