package com.ifs21024.delcomtodo.presentation.todo

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.ifs21024.delcomtodo.data.remote.MyResult
import com.ifs21024.delcomtodo.data.remote.resoponse.DataAddTodoResponse
import com.ifs21024.delcomtodo.data.remote.resoponse.DelcomResponse
import com.ifs21024.delcomtodo.data.remote.resoponse.DelcomTodoResponse
import com.ifs21024.delcomtodo.data.repository.TodoRepository
import com.ifs21024.delcomtodo.presentation.ViewModelFactory

class TodoViewModel(
    private val todoRepository: TodoRepository
) : ViewModel() {

    fun getTodo(todoId: Int): LiveData<MyResult<DelcomTodoResponse>>{
        return todoRepository.getTodo(todoId).asLiveData()
    }

    fun postTodo(
        title: String,
        description: String,
    ): LiveData<MyResult<DataAddTodoResponse>>{
        return todoRepository.postTodo(
            title,
            description
        ).asLiveData()
    }

    fun putTodo(
        todoId: Int,
        title: String,
        description: String,
        isFinished: Boolean,
    ): LiveData<MyResult<DelcomResponse>> {
        return todoRepository.putTodo(
            todoId,
            title,
            description,
            isFinished,
        ).asLiveData()
    }

    fun deleteTodo(todoId: Int): LiveData<MyResult<DelcomResponse>> {
        return todoRepository.deleteTodo(todoId).asLiveData()
    }

    companion object {
        @Volatile
        private var INSTANCE: TodoViewModel? = null
        fun getInstance(
            todoRepository: TodoRepository
        ): TodoViewModel {
            synchronized(ViewModelFactory::class.java) {
                INSTANCE = TodoViewModel(
                    todoRepository
                )
            }
            return INSTANCE as TodoViewModel
        }
    }
}