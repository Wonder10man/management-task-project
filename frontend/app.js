// Simulate tasks in memory
let taskList = [];

// Add Task Functionality
const taskForm = document.getElementById("task-form");
const tasksContainer = document.getElementById("tasks");

taskForm.addEventListener("submit", (event) => {
  event.preventDefault(); // Prevent page reload

  const taskName = document.getElementById("taskName").value;
  const dueDate = document.getElementById("dueDate").value;

  if (!taskName || !dueDate) {
    alert("Please fill out all fields!");
    return;
  }

  // Create a new task object
  const newTask = {
    id: Date.now(),
    name: taskName,
    date: dueDate,
  };

  // Add task to the list
  taskList.push(newTask);
  renderTasks();

  // Clear the form
  taskForm.reset();
});

// Render Task List
function renderTasks() {
  // Clear current tasks
  tasksContainer.innerHTML = "";

  taskList.forEach((task) => {
    const taskItem = document.createElement("li");
    taskItem.innerHTML = `
            <span>${task.name} - ${task.date}</span>
            <button onclick="deleteTask(${task.id})">Delete</button>
        `;
    tasksContainer.appendChild(taskItem);
  });
}

// Delete Task
function deleteTask(id) {
  taskList = taskList.filter((task) => task.id !== id);
  renderTasks();
}
