#include <iostream>
using namespace std;

// Strategy Pattern
// The Strategy Pattern defines a family of algorithms, encapsulates each one, and makes them interchangeable.
// Strategy lets the algorithm vary independently from clients that use it.

// This is the interface that all concrete strategies must implement
class IExecuteNextMove{
public:
    virtual void PerformNextMove(void) = 0;
};

// First concrete class
class StrategyEasy : public IExecuteNextMove{
public:
    void PerformNextMove(void) override{
        cout << "Performing easy move" << endl;
    }
};

// Second concrete class
class StrategyMedium : public IExecuteNextMove{
    public:
    void PerformNextMove(void) override{
        cout << "Performing medium move" << endl;
    }
};

// Third concrete class
class StrategyHard : public IExecuteNextMove{
    public:
    void PerformNextMove(void) override{
        cout << "Performing hard move" << endl;
    }
};


// Parent class that aggregates the interface class
class Chess{
    private:
    IExecuteNextMove* strategy;

    public:
    Chess(IExecuteNextMove* strategy){
        this->strategy = strategy;
    }

    void SetStrategy(IExecuteNextMove* strategy){
        this->strategy = strategy;
    }

    void ExecuteNextMove(){
        this->strategy->PerformNextMove();
    }
};

int main() {
    Chess chess(new StrategyEasy());
    chess.ExecuteNextMove();

    chess.SetStrategy(new StrategyMedium());
    chess.ExecuteNextMove();

    chess.SetStrategy(new StrategyHard());
    chess.ExecuteNextMove();
    
    return 0;
}